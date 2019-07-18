package de.resistome.resistomedb;

import de.resistome.resistomedb.controllers.ResistomeDbController;
import de.resistome.resistomedb.service.DataFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class ResistomeDbApplication implements CommandLineRunner {


    @Autowired
    DataFileReader dataFileReader;

    public static void main(String[] args) {
        SpringApplication.run(ResistomeDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {

            if(args[0].equals("filler")) {

                dataFileReader.readMetaRuns("data/meta_runs.tsv");

                dataFileReader.readMeta2("data/meta2.tsv");

                dataFileReader.readDeepArgKaiju("data/deepARG_plas_kaiju_RNA.tsv");

                //dataFileReader.readFpkm("data/FPKMs.tsv");
            }
            else if(args[0].equals("web")){
                //run the web app through the contoller
                System.out.println("I'm in the webapp");
            }
            else{
                System.out.println("Wrong program parameter, please, choose between 'filler' and 'web'");
                exit(0);
            }
        }

    }
}
