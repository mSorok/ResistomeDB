package de.resistome.resistomedb.service;


import de.resistome.resistomedb.misc.BeanUtil;
import de.resistome.resistomedb.misc.Utilities;
import de.resistome.resistomedb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static javax.script.ScriptEngine.FILENAME;

@Service
public class DataFileReader {

    @Autowired
    OrfRepository orfRepository;

    @Autowired
    SampleRepository sampleRepository;


    @Autowired
    SampleOrfCpdRepository sampleOrfCpdRepository;

    @Autowired
    ArgClassRepository argClassRepository;

    @Autowired
    ArgRepository argRepository;

    @Autowired
    ArgOrfCpdRepository argOrfCpdRepository;

    Utilities utilities ;



    public void readMedia2(String fileName){
        //for each line, extract the ARG from the database

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                if(!line.contains("ARG;Q")){
                    String [] tab = line.split(";");

                    Arg a = argRepository.findByArgName(tab[0]).get(0);

                    a.setQuantification(tab[1]);
                    a.setScenario(tab[2]);

                    argRepository.save(a);



                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        //update the fields accordingly

        //save to the database


    }

    public boolean readMetaRuns(String fileName){
        boolean workDone = false;

        //for each line - check if already exists


        Hashtable<String, Sample> samples = new Hashtable<>();


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String [] tab = line.split("\t");

                //tab[0] = sample_id_explained - check if already created
                if( !line.startsWith("Sample label") && ! samples.containsKey(tab[0]) ){

                    Sample sample = new Sample();

                    sample.setSample_id_explained(tab[0]);

                    sample.setInsdc_sample_acc_number(tab[1]);

                    sample.setInsdc_run_acc_number(tab[2]);

                    String [] runs = tab[2].split("|");

                    sample.setRun_accession( new ArrayList( Arrays.asList( runs ) ) );

                    //tab[3] Corresponding nucleotides data published at ENA (URL)

                    sample.setPangea_id(tab[4]);

                    //tab[5] Corresponding contextual data published at PANGAEA (URL)

                    sample.setStation_id(tab[6]);

                    sample.setDate_time( tab[7] );

                    sample.setMean_lattitude(Double.parseDouble( tab[8]) );

                    sample.setMean_longitude(Double.parseDouble( tab[9]) ) ;

                    sample.setBiosample_depth( Double.parseDouble( tab[10] ) );

                    sample.setEnvironmental_feature( tab[11]);


                    if( !tab[12].equals(">") && !tab[12].equals("<") ){
                        sample.setSize_fraction_lower_threshold( Double.parseDouble( tab[12] ));
                    }


                    sample.setSize_fraction_upper_threshold( Double.parseDouble( tab[13]) );

                    sample.setBiogeographic_biomes(tab[14]);

                    sample.setRegion(tab[15]);

                    sample.setMarine_provinces(tab[16]);

                    //tab[17] = value = one run_accession



//0	12	3	4	5 6	7	8	9	10	11	12	13	14	15 16	17



                    samples.put(tab[0], sample);

                }





            }


            workDone=true;


        } catch (IOException e) {
            workDone=false;
            e.printStackTrace();
        }

        sampleRepository.saveAll( samples.values() );


        return workDone;
    }


    public boolean readFpkm(String fileName){

        boolean workDone = false;

        //read file and read the matrix

        String[][] resultArray;

        List<String> lines = null;



        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        lines.removeAll(Arrays.asList("", null)); // <- remove empty lines

        resultArray = new String[lines.size()][];

        for(int i =0; i<lines.size(); i++){
            resultArray[i] = lines.get(i).split("\t"); //tab-separated
        }


        //System.out.println(resultArray[0][1]); <- first ERR


        System.out.println(resultArray[0][0]);
            System.out.println(resultArray[0][1]);
            System.out.println(resultArray[1][0]);
        System.out.println(resultArray[1][1]);

            ArrayList<String> runAccessions = new ArrayList<>(  Arrays.asList(resultArray[0]) );

            ArrayList<String> orfIds = new ArrayList<>( Arrays.asList( getColumn(resultArray, 0) ) );

            System.out.println(runAccessions);
            System.out.println(orfIds);



        //TODO  find the objects with the corresponding ORF id and the samples with the run_accession



         for(int run_number = 1; run_number<runAccessions.size(); run_number++){

             Integer sample_id = sampleRepository.findIdByRunAccession(runAccessions.get(run_number));

             for(int orf_number = 1; orf_number<orfIds.size(); orf_number++){
                 Integer orf_id = orfRepository.findIdByyOrfNt(resultArray[run_number][0]);

                 Double fpkm = Double.parseDouble(resultArray[run_number][orf_number]);

                 SampleOrfCpd soc = new SampleOrfCpd();

                 soc.setSampleid(sample_id);
                 soc.setOrfid(orf_id);
                 soc.setRun_accession(runAccessions.get(run_number));
                 soc.setFpkm(fpkm);


                 sampleOrfCpdRepository.save(soc);

             }
         }


        } catch (IOException e) {
            e.printStackTrace();
            workDone=false;
            return workDone;
        }


        workDone=true;

        return workDone;

    }


    public boolean readMeta2(String fileName){
        boolean workDone = false;


        utilities = BeanUtil.getBean(Utilities.class);




        List<Sample> samples = utilities.toList(  sampleRepository.findAll()  );

        Hashtable<String, Sample> hashSamples = new Hashtable<>();
        for(Sample s : samples){
            hashSamples.put(s.getPangea_id(), s);
        }


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                if (!line.startsWith("PANGAEA Sample ID")) {

                    String[] tab = line.split("\t");

                    if(tab.length<33){
                        System.out.println(line);
                        String[] t2 = new String[30];
                        for(int i =0;i<t2.length;i++){
                            t2[i] = "";
                        }


                        tab = concatenate(tab,t2);


                    }

                    if (hashSamples.containsKey(tab[0])) {

                        hashSamples.get(tab[0]).setMean_date( tab[1]) ;

                        hashSamples.get(tab[0]).setMean_lattitude(Double.parseDouble(tab[2]));
                        hashSamples.get(tab[0]).setMean_longitude(Double.parseDouble(tab[3]));
                        if(!tab[4].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth(Double.parseDouble(tab[4]));
                        }
                        if(!tab[5].equals("")) {
                            hashSamples.get(tab[0]).setMean_temperature(Double.parseDouble(tab[5]));
                        }
                        if(!tab[6].equals("")) {
                            hashSamples.get(tab[0]).setMean_salinity(Double.parseDouble(tab[6]));
                        }
                        if(!tab[7].equals("")) {
                            hashSamples.get(tab[0]).setMean_oxygen(Double.parseDouble(tab[7]));
                        }
                        if(!tab[8].equals("")) {
                            hashSamples.get(tab[0]).setMean_nitrates(Double.parseDouble(tab[8]));
                        }
                        if(!tab[9].equals("")) {
                            hashSamples.get(tab[0]).setNo2(Double.parseDouble(tab[9]));
                        }
                        if(!tab[10].equals("")) {
                            hashSamples.get(tab[0]).setPo4(Double.parseDouble(tab[10]));
                        }
                        if(!tab[11].equals("")) {
                            hashSamples.get(tab[0]).setNo2no3(Double.parseDouble(tab[11]));
                        }
                        if(!tab[12].equals("")) {
                            hashSamples.get(tab[0]).setSi(Double.parseDouble(tab[12]));
                        }
                        if(!tab[13].equals("")) {
                            hashSamples.get(tab[0]).setAmodis(Double.parseDouble(tab[13]));
                        }
                        if(!tab[14].equals("")) {
                            hashSamples.get(tab[0]).setOkubo_weiss(Double.parseDouble(tab[14]));
                        }
                        if(!tab[15].equals("")) {
                            hashSamples.get(tab[0]).setGrad_sst_adv(Double.parseDouble(tab[15]));
                        }
                        if(!tab[16].equals("")) {
                            hashSamples.get(tab[0]).setRetention(Double.parseDouble(tab[16]));
                        }
                        if(!tab[17].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth_mld_sigma(Double.parseDouble(tab[17]));
                        }
                        if(!tab[18].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth_max_fluo(Double.parseDouble(tab[18]));
                        }
                        if(!tab[19].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth_max_n2(Double.parseDouble(tab[19]));
                        }
                        if(!tab[20].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth_max_o2(Double.parseDouble(tab[20]));
                        }
                        if(!tab[21].equals("")){
                            hashSamples.get(tab[0]).setMean_depth_min_o2(Double.parseDouble(tab[21]));
                        }
                        if(!tab[22].equals("")) {
                            hashSamples.get(tab[0]).setMean_depth_nitracline(Double.parseDouble(tab[22]));
                        }
                        if(!tab[23].equals("")) {
                            hashSamples.get(tab[0]).setMitag_silva_taxo_richness(Double.parseDouble(tab[23]));
                        }
                        if(!tab[24].equals("")) {
                            hashSamples.get(tab[0]).setMitag_silva_chao(Double.parseDouble(tab[24]));
                        }
                        if(!tab[25].equals("")) {
                            hashSamples.get(tab[0]).setMitag_silva_shannon(Double.parseDouble(tab[25]));
                        }
                        if(!tab[26].equals("")) {
                            hashSamples.get(tab[0]).setOg_shannon(Double.parseDouble(tab[26]));
                        }
                        if(!tab[27].equals("")) {
                            hashSamples.get(tab[0]).setOg_richness(Double.parseDouble(tab[27]));
                        }
                        if(!tab[28].equals("")) {
                            hashSamples.get(tab[0]).setOg_evenness(Double.parseDouble(tab[28]));
                        }
                        if(!tab[29].equals("")) {
                            hashSamples.get(tab[0]).setFc_heterotrophs(Double.parseDouble(tab[29]));
                        }
                        if(!tab[30].equals("")) {
                            hashSamples.get(tab[0]).setFc_autotrophs(Double.parseDouble(tab[30]));
                        }
                        if(!tab[31].equals("")) {
                            hashSamples.get(tab[0]).setFc_bacteria(Double.parseDouble(tab[31]));
                        }
                        if(!tab[32].equals("")) {
                            hashSamples.get(tab[0]).setFc_picoeukaryotes(Double.parseDouble(tab[32]));
                        }
                        if(!tab[33].equals("")) {
                            hashSamples.get(tab[0]).setMinimum_generation_time(Double.parseDouble(tab[33]));
                        }


//0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27 28	29	30	31	32	33


                    } else {

                        Sample s = new Sample();
                        s.setPangea_id(tab[0]);
                        s.setMean_date(tab[1]);

                        s.setMean_lattitude(Double.parseDouble(tab[2]));
                        s.setMean_longitude(Double.parseDouble(tab[3]));
                        s.setMean_depth(Double.parseDouble(tab[4]));
                        s.setMean_temperature(Double.parseDouble(tab[5]));
                        s.setMean_salinity(Double.parseDouble(tab[6]));
                        s.setMean_oxygen(Double.parseDouble(tab[7]));
                        s.setMean_nitrates(Double.parseDouble(tab[8]));
                        s.setNo2(Double.parseDouble(tab[9]));
                        s.setPo4(Double.parseDouble(tab[10]));
                        s.setNo2no3(Double.parseDouble(tab[11]));
                        s.setSi(Double.parseDouble(tab[12]));
                        s.setAmodis(Double.parseDouble(tab[13]));
                        s.setOkubo_weiss(Double.parseDouble(tab[14]));
                        s.setGrad_sst_adv(Double.parseDouble(tab[15]));
                        s.setRetention(Double.parseDouble(tab[16]));
                        s.setMean_depth_mld_sigma(Double.parseDouble(tab[17]));
                        s.setMean_depth_max_fluo(Double.parseDouble(tab[18]));
                        s.setMean_depth_max_n2(Double.parseDouble(tab[19]));
                        s.setMean_depth_max_o2(Double.parseDouble(tab[20]));
                        s.setMean_depth_min_o2(Double.parseDouble(tab[21]));
                        s.setMean_depth_nitracline(Double.parseDouble(tab[22]));
                        s.setMitag_silva_taxo_richness(Double.parseDouble(tab[23]));
                        s.setMitag_silva_chao(Double.parseDouble(tab[24]));
                        s.setMitag_silva_shannon(Double.parseDouble(tab[25]));
                        s.setOg_shannon(Double.parseDouble(tab[26]));
                        s.setOg_richness(Double.parseDouble(tab[27]));
                        s.setOg_evenness(Double.parseDouble(tab[28]));
                        s.setFc_heterotrophs(Double.parseDouble(tab[29]));
                        s.setFc_autotrophs(Double.parseDouble(tab[30]));
                        s.setFc_bacteria(Double.parseDouble(tab[31]));
                        s.setFc_picoeukaryotes(Double.parseDouble(tab[32]));
                        s.setMinimum_generation_time(Double.parseDouble(tab[33]));

                        sampleRepository.save(s);

                        System.out.println("!!!!!! NEW SAMPLE CREATES FROM META2");
                        System.out.println(line);
                    }


                }
            }



            sampleRepository.saveAll(hashSamples.values());

            workDone=true;

        } catch (IOException e) {
            workDone=false;
            e.printStackTrace();
        }




        return workDone;
    }


    public boolean readDeepArgKaiju(String fileName){

        boolean workDone = false;

        Hashtable<String, Orf> allOrfs = new Hashtable<>();
        Hashtable<String, Arg> allArgs = new Hashtable<>();

        Hashtable<String, ArgClass> allArgClass = new Hashtable<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                if(!line.startsWith("#ARG")){

                    String [] tab = line.split("\t");

                    ArgClass argClass;
                    Arg arg;

                    if(allArgClass.containsKey(tab[4])){
                        //the Arf class was already created
                        argClass = allArgClass.get(tab[4]);
                    }
                    else{
                        //create new arg class
                        argClass = new ArgClass();
                        argClass.setArg_class_name(tab[4]);

                        argClass = argClassRepository.save(argClass);
                        allArgClass.put(argClass.getArg_class_name(), argClass);

                    }

                    if(allArgs.containsKey(tab[0])){
                        //the Arf was already created
                        arg = allArgs.get(tab[0]);
                    }
                    else{
                        //create new arg
                        arg = new Arg();
                        arg.setArg(tab[0]);
                        arg.setArg_class_name(tab[4]);

                        arg = argRepository.save(arg);
                        allArgs.put(arg.getArg(), arg);

                    }



                    //Create Orf with tab[20]
                    Orf orf = new Orf();
                    orf.setOrf(tab[20]);
                    orf.setOrf_nt(tab[3]);
                    orf.setAssembled_region_id(tab[12]);
                    orf.setGene(tab[13]);
                    orf.setContig_id(tab[14]);
                    orf.setOrf_pt(tab[15]);
                    orf.setContig_length(Integer.parseInt(tab[16]));
                    orf.setLabel(tab[17]);
                    orf.setPlasmid(tab[18]);
                    orf.setPlasflow_phyla(tab[19]);
                    orf.setTaxon_kaiju(Integer.parseInt(tab[21]));
                    orf.setTaxon_name_kaiju(tab[22]);
                    orf.setHeader_ptn_for_phylogeny(tab[23]);
                    orf.setIsExpressed(tab[24]);




                    orf = orfRepository.save(orf);



                    //Create the ArgOrfCpd object

                    ArgOrfCpd aoc = new ArgOrfCpd();
                    aoc.setOrf_id(orf.getOrf_id());
                    aoc.setArg_id(arg.getArg_id());
                    aoc.setQuery_start( Integer.parseInt(tab[1]) );
                    aoc.setQuery_end(Integer.parseInt(tab[2]));
                    aoc.setBest_hit(tab[5]);
                    aoc.setProbability(Double.parseDouble(tab[6]) );
                    aoc.setIdentity(Double.parseDouble(tab[7]));
                    aoc.setAlignment_length(Integer.parseInt(tab[8]));
                    aoc.setAlignment_bitscore(Double.parseDouble(tab[9]));
                    aoc.setAlignment_evalue(Double.parseDouble(tab[10]));
                    aoc.setProblematic_classification(Integer.parseInt(tab[11]));

                    argOrfCpdRepository.save(aoc);




                }
            }

            workDone=true;
        } catch (IOException e) {
            workDone=false;

            e.printStackTrace();
        }




        return workDone;

    }






    public static String[] getColumn(String[][] array, int index){
        String[] column = new String[array[0].length]; // Here I assume a rectangular 2D array!
        for(int i=0; i<column.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }

    public <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }
}
