package de.resistome.resistomedb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="sample", indexes = {  @Index(name = "IDX1", columnList = "sampleid", unique = true)} )
public class Sample {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer sample_id;

    private String sample_id_explained; // Sample label [TARA_station#_environmental-feature_size-fraction] - FROM meta_fordb

    private String pangea_id; // PANGEA Sample ID (in meta2) or PANGEA sample identifier in meta_dordb

    private ArrayList<String> run_accession; // starts with ERR - corresponds to the ID from the ENA runs - "value" in meta_fordb

    @Column(name = "mean_date", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mean_date; //Mean_Date [YY/MM/DD hh:mm]* from meta2

    @Column(name = "date_time", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_time; //Date/Time [yyyy-mm-ddThh:mm] from meta_fordb

    private Double mean_lattitude; //Mean_Lat* from meta2 AND Latitude [degrees North] from meta_fordb

    private Double mean_longitude; //Mean_Long* from meta2 AND Longitude [degrees East] from meta_fordb

    private Double mean_depth; //Mean_Depth [m] from meta2

    private Double biosample_depth; // Sampling depth [m] from meta_fordb

    private Double mean_temperature; //Mean_Temperature [deg C]* from meta2

    private Double mean_salinity; //Mean_Salinity [PSU]* from meta2

    private Double mean_oxygen; //Mean_Oxygen [umol/kg]* from meta2

    private Double mean_nitrates; //Mean_Nitrates[umol/L]* from meta2

    private Double no2; //NO2 [umol/L]** from meta2

    private Double po4; //PO4 [umol/L]** from meta2

    private Double no2no3; // NO2NO3 [umol/L]** from meta2

    private Double si; // SI [umol/L]** from meta2

    private Double amodis; //AMODIS:PAR8d,Einsteins/m-2/d-1

    private Double okubo_weiss;//Okubo-Weiss

    private Double lyapunov; //// Lyapunov_exp.

    private Double grad_sst_adv; //grad_SST_adv

    private Double retention_mean_depth_mld_sigma; //retention	Mean Depth MLD Sigma [m]*

    private Double mean_depth_max_fluo; //Mean Depth Max Fluo [m]*

    private Double mean_depth_max_n2; //Mean Depth Max N2 [m]*

    private Double mean_depth_max_o2; //Mean Depth Max O2 [m]*

    private Double mean_depth_min_o2; //Mean Depth Min O2 [m]*

    private Double mean_depth_nitracline; //Mean Depth Nitracline [m]*

    private Double mitag_silva_taxo_richness; //miTAG.SILVA.Taxo.Richness

    private Double mitag_silva_phylo_diversity; //miTAG.SILVA.Phylo.Diversity

    private Double mitag_silva_chao; //miTAG.SILVA.Chao

    private Double mitag_silva_ace; //miTAG.SILVA.ace

    private Double mitag_silva_shannon; //miTAG.SILVA.Shannon

    private Double og_shannon;//OG.Shannon

    private Double og_richness; //OG.Richness

    private Double og_evenness; //OG.Evenness

    private Double fc_heterotrophs; //FC - heterotrophs [cells/mL]

    private Double fc_autotrophs; //FC - autotrophs [cells/mL]

    private Double fc_bacteria; //FC - bacteria [cells/mL]

    private Double fc_picoeukaryotes; //FC - picoeukaryotes [cells/mL]

    private Integer minimum_generation_time; //minimum generation time [h] from meta2

    private String insdc_sample_acc_number; // from meta_fordb - ERS....

    private String insdc_run_acc_number ; //from meta_fordb ERR598950|ERR599095

    private String station_id; // from meta_fordb : Station identifier [TARA_station#]

    public String environmental_feature ; // Environmental Feature from meta_fordb

    private Double size_fraction_lower_threshold ; // Size fraction lower threshold [micrometre] from meta_fordb

    private Double size_fraction_upper_threshold ; // Size fraction upper threshold [micrometre] from meta_fordb

    public String marine_pelagic_biomes; // Marine pelagic biomes (Longhurst 2007) from meta_fordb

    public String marine_pelagic_biomes_mrgid; //Marine pelagic biomes  (Longhurst 2007) [MRGID registered at www.marineregions.com]

    public String region;  //Ocean and sea regions (IHO General Sea Areas 1953) [MRGID registered at www.marineregions.com] from meta_fordb






    private Integer variable; //variable from meta_fordb






    //meta_fordb: ,,,Corresponding nucleotides data published at ENA,,Corresponding contextual data published at PANGAEA,,,,,,,,,,,Marine pelagic biomes  (Longhurst 2007) [MRGID registered at www.marineregions.com] ,variable,value

//Sample label [TARA_station#_environmental-feature_size-fraction],INSDC sample accession number(s),INSDC run accession number(s),Corresponding nucleotides data published at ENA,PANGAEA sample identifier,Corresponding contextual data published at PANGAEA,Station identifier [TARA_station#],Date/Time [yyyy-mm-ddThh:mm],Latitude [degrees North],Longitude [degrees East],Sampling depth [m],Environmental Feature,Size fraction lower threshold [micrometre],Size fraction upper threshold [micrometre],Marine pelagic biomes (Longhurst 2007),Ocean and sea regions (IHO General Sea Areas 1953) [MRGID registered at www.marineregions.com],Marine pelagic biomes  (Longhurst 2007) [MRGID registered at www.marineregions.com] ,variable,value
    //TARA_004_DCM_0.22-1.6,ERS487936,ERR598950|ERR599095,"http://www.ebi.ac.uk/ena/data/view/ERR598950,ERR599095",TARA_X000000368,http://www.pangaea.de/search?All&q=TARA_X000000368,TARA_004,2009-09-15T18:00,36.5533,-6.5669,40,(DCM) deep chlorophyll maximum layer (ENVO:01000326),0.22,1.6,Westerlies Biome,(NAO) North Atlantic Ocean [MRGID:1912],(NAST-E) North Atlantic Subtropical Gyral Province [MRGID:21467],0,ERR598950


    //,,,"http://www.ebi.ac.uk/ena/data/view/ERR598950,ERR599095",,http://www.pangaea.de/search?All&q=TARA_X000000368,,,,,,,,,,,(NAST-E) North Atlantic Subtropical Gyral Province [MRGID:21467],0,ERR598950
}
