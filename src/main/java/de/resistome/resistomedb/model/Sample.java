package de.resistome.resistomedb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="sample", indexes = {  @Index(name = "IDX1", columnList = "sample_id", unique = true)} )
public class Sample {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer sample_id;

    private String sample_id_explained; // Sample label [TARA_station#_environmental-feature_size-fraction] - FROM meta_fordb

    private String pangea_id; // PANGEA Sample ID (in meta2) or PANGEA sample identifier in meta_fordb

    private ArrayList<String> run_accession; // starts with ERR - corresponds to the ID from the ENA runs - "value" in meta_fordb

/*    @Column(name = "mean_date", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)*/
    private Date mean_date; //Mean_Date [YY/MM/DD hh:mm]* from meta2

/*    @Column(name = "date_time", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)*/
    private Date date_time; //Date/Time [yyyy-mm-ddThh:mm] from meta_runs

    private Double mean_lattitude; //Mean_Lat* from meta2 AND Latitude [degrees North] from meta_runs

    private Double mean_longitude; //Mean_Long* from meta2 AND Longitude [degrees East] from meta_runs

    private Double mean_depth; //Mean_Depth [m] from meta2

    private Double biosample_depth; // Sampling depth [m] from meta_runs

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

    private Double retention; //retention
    private Double mean_depth_mld_sigma; //Mean Depth MLD Sigma [m]*

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

    private String insdc_sample_acc_number; // from meta_runs - ERS....

    private String insdc_run_acc_number ; //from meta_runs ERR598950|ERR599095

    private String station_id; // from meta_runs : Station identifier [TARA_station#]

    public String environmental_feature ; // Environmental Feature from meta_runs

    private Double size_fraction_lower_threshold ; // Size fraction lower threshold [micrometre] from meta_runs

    private Double size_fraction_upper_threshold ; // Size fraction upper threshold [micrometre] from meta_fordb

    public String biogeographic_biomes; // Marine pelagic biomes (Longhurst 2007) from meta_fordb

    public String marine_provinces; //Marine pelagic biomes  (Longhurst 2007) [MRGID registered at www.marineregions.com]

    public String region;  //Ocean and sea regions (IHO General Sea Areas 1953) [MRGID registered at www.marineregions.com] from meta_fordb






    private Integer variable; //variable from meta_fordb






    //meta_fordb: ,,,Corresponding nucleotides data published at ENA,,Corresponding contextual data published at PANGAEA,,,,,,,,,,,


    //,,,"http://www.ebi.ac.uk/ena/data/view/ERR598950,ERR599095",,http://www.pangaea.de/search?All&q=TARA_X000000368,,,,,,,,,,,-


    public Integer getSample_id() {
        return sample_id;
    }

    public void setSample_id(Integer sample_id) {
        this.sample_id = sample_id;
    }

    public String getSample_id_explained() {
        return sample_id_explained;
    }

    public void setSample_id_explained(String sample_id_explained) {
        this.sample_id_explained = sample_id_explained;
    }

    public String getPangea_id() {
        return pangea_id;
    }

    public void setPangea_id(String pangea_id) {
        this.pangea_id = pangea_id;
    }

    public ArrayList<String> getRun_accession() {
        return run_accession;
    }

    public void setRun_accession(ArrayList<String> run_accession) {
        this.run_accession = run_accession;
    }

    public Date getMean_date() {
        return mean_date;
    }

    public void setMean_date(Date mean_date) {
        this.mean_date = mean_date;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Double getMean_lattitude() {
        return mean_lattitude;
    }

    public void setMean_lattitude(Double mean_lattitude) {
        this.mean_lattitude = mean_lattitude;
    }

    public Double getMean_longitude() {
        return mean_longitude;
    }

    public void setMean_longitude(Double mean_longitude) {
        this.mean_longitude = mean_longitude;
    }

    public Double getMean_depth() {
        return mean_depth;
    }

    public void setMean_depth(Double mean_depth) {
        this.mean_depth = mean_depth;
    }

    public Double getBiosample_depth() {
        return biosample_depth;
    }

    public void setBiosample_depth(Double biosample_depth) {
        this.biosample_depth = biosample_depth;
    }

    public Double getMean_temperature() {
        return mean_temperature;
    }

    public void setMean_temperature(Double mean_temperature) {
        this.mean_temperature = mean_temperature;
    }

    public Double getMean_salinity() {
        return mean_salinity;
    }

    public void setMean_salinity(Double mean_salinity) {
        this.mean_salinity = mean_salinity;
    }

    public Double getMean_oxygen() {
        return mean_oxygen;
    }

    public void setMean_oxygen(Double mean_oxygen) {
        this.mean_oxygen = mean_oxygen;
    }

    public Double getMean_nitrates() {
        return mean_nitrates;
    }

    public void setMean_nitrates(Double mean_nitrates) {
        this.mean_nitrates = mean_nitrates;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getPo4() {
        return po4;
    }

    public void setPo4(Double po4) {
        this.po4 = po4;
    }

    public Double getNo2no3() {
        return no2no3;
    }

    public void setNo2no3(Double no2no3) {
        this.no2no3 = no2no3;
    }

    public Double getSi() {
        return si;
    }

    public void setSi(Double si) {
        this.si = si;
    }

    public Double getAmodis() {
        return amodis;
    }

    public void setAmodis(Double amodis) {
        this.amodis = amodis;
    }

    public Double getOkubo_weiss() {
        return okubo_weiss;
    }

    public void setOkubo_weiss(Double okubo_weiss) {
        this.okubo_weiss = okubo_weiss;
    }

    public Double getLyapunov() {
        return lyapunov;
    }

    public void setLyapunov(Double lyapunov) {
        this.lyapunov = lyapunov;
    }

    public Double getGrad_sst_adv() {
        return grad_sst_adv;
    }

    public void setGrad_sst_adv(Double grad_sst_adv) {
        this.grad_sst_adv = grad_sst_adv;
    }

    public Double getRetention() {
        return retention;
    }

    public void setRetention(Double retention) {
        this.retention = retention;
    }

    public Double getMean_depth_mld_sigma() {
        return mean_depth_mld_sigma;
    }

    public void setMean_depth_mld_sigma(Double mean_depth_mld_sigma) {
        this.mean_depth_mld_sigma = mean_depth_mld_sigma;
    }

    public Double getMean_depth_max_fluo() {
        return mean_depth_max_fluo;
    }

    public void setMean_depth_max_fluo(Double mean_depth_max_fluo) {
        this.mean_depth_max_fluo = mean_depth_max_fluo;
    }

    public Double getMean_depth_max_n2() {
        return mean_depth_max_n2;
    }

    public void setMean_depth_max_n2(Double mean_depth_max_n2) {
        this.mean_depth_max_n2 = mean_depth_max_n2;
    }

    public Double getMean_depth_max_o2() {
        return mean_depth_max_o2;
    }

    public void setMean_depth_max_o2(Double mean_depth_max_o2) {
        this.mean_depth_max_o2 = mean_depth_max_o2;
    }

    public Double getMean_depth_min_o2() {
        return mean_depth_min_o2;
    }

    public void setMean_depth_min_o2(Double mean_depth_min_o2) {
        this.mean_depth_min_o2 = mean_depth_min_o2;
    }

    public Double getMean_depth_nitracline() {
        return mean_depth_nitracline;
    }

    public void setMean_depth_nitracline(Double mean_depth_nitracline) {
        this.mean_depth_nitracline = mean_depth_nitracline;
    }

    public Double getMitag_silva_taxo_richness() {
        return mitag_silva_taxo_richness;
    }

    public void setMitag_silva_taxo_richness(Double mitag_silva_taxo_richness) {
        this.mitag_silva_taxo_richness = mitag_silva_taxo_richness;
    }

    public Double getMitag_silva_phylo_diversity() {
        return mitag_silva_phylo_diversity;
    }

    public void setMitag_silva_phylo_diversity(Double mitag_silva_phylo_diversity) {
        this.mitag_silva_phylo_diversity = mitag_silva_phylo_diversity;
    }

    public Double getMitag_silva_chao() {
        return mitag_silva_chao;
    }

    public void setMitag_silva_chao(Double mitag_silva_chao) {
        this.mitag_silva_chao = mitag_silva_chao;
    }

    public Double getMitag_silva_ace() {
        return mitag_silva_ace;
    }

    public void setMitag_silva_ace(Double mitag_silva_ace) {
        this.mitag_silva_ace = mitag_silva_ace;
    }

    public Double getMitag_silva_shannon() {
        return mitag_silva_shannon;
    }

    public void setMitag_silva_shannon(Double mitag_silva_shannon) {
        this.mitag_silva_shannon = mitag_silva_shannon;
    }

    public Double getOg_shannon() {
        return og_shannon;
    }

    public void setOg_shannon(Double og_shannon) {
        this.og_shannon = og_shannon;
    }

    public Double getOg_richness() {
        return og_richness;
    }

    public void setOg_richness(Double og_richness) {
        this.og_richness = og_richness;
    }

    public Double getOg_evenness() {
        return og_evenness;
    }

    public void setOg_evenness(Double og_evenness) {
        this.og_evenness = og_evenness;
    }

    public Double getFc_heterotrophs() {
        return fc_heterotrophs;
    }

    public void setFc_heterotrophs(Double fc_heterotrophs) {
        this.fc_heterotrophs = fc_heterotrophs;
    }

    public Double getFc_autotrophs() {
        return fc_autotrophs;
    }

    public void setFc_autotrophs(Double fc_autotrophs) {
        this.fc_autotrophs = fc_autotrophs;
    }

    public Double getFc_bacteria() {
        return fc_bacteria;
    }

    public void setFc_bacteria(Double fc_bacteria) {
        this.fc_bacteria = fc_bacteria;
    }

    public Double getFc_picoeukaryotes() {
        return fc_picoeukaryotes;
    }

    public void setFc_picoeukaryotes(Double fc_picoeukaryotes) {
        this.fc_picoeukaryotes = fc_picoeukaryotes;
    }

    public Integer getMinimum_generation_time() {
        return minimum_generation_time;
    }

    public void setMinimum_generation_time(Integer minimum_generation_time) {
        this.minimum_generation_time = minimum_generation_time;
    }

    public String getInsdc_sample_acc_number() {
        return insdc_sample_acc_number;
    }

    public void setInsdc_sample_acc_number(String insdc_sample_acc_number) {
        this.insdc_sample_acc_number = insdc_sample_acc_number;
    }

    public String getInsdc_run_acc_number() {
        return insdc_run_acc_number;
    }

    public void setInsdc_run_acc_number(String insdc_run_acc_number) {
        this.insdc_run_acc_number = insdc_run_acc_number;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getEnvironmental_feature() {
        return environmental_feature;
    }

    public void setEnvironmental_feature(String environmental_feature) {
        this.environmental_feature = environmental_feature;
    }

    public Double getSize_fraction_lower_threshold() {
        return size_fraction_lower_threshold;
    }

    public void setSize_fraction_lower_threshold(Double size_fraction_lower_threshold) {
        this.size_fraction_lower_threshold = size_fraction_lower_threshold;
    }

    public Double getSize_fraction_upper_threshold() {
        return size_fraction_upper_threshold;
    }

    public void setSize_fraction_upper_threshold(Double size_fraction_upper_threshold) {
        this.size_fraction_upper_threshold = size_fraction_upper_threshold;
    }

    public String getBiogeographic_biomes() {
        return biogeographic_biomes;
    }

    public void setBiogeographic_biomes(String biogeographic_biomes) {
        this.biogeographic_biomes = biogeographic_biomes;
    }

    public String getMarine_provinces() {
        return marine_provinces;
    }

    public void setMarine_provinces(String marine_provinces) {
        this.marine_provinces = marine_provinces;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getVariable() {
        return variable;
    }

    public void setVariable(Integer variable) {
        this.variable = variable;
    }
}
