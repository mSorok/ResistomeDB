package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SampleOrfCpd {

    //FPKM

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer socpdid;

    private Integer sample_id;

    private String run_accession; //TODO to figure out how to eliminate redundancy

    private Integer orf_id;

    public Double fpkm; // to the future : eventually SUM or corrected SUM or the MEAN (to be determined) of the fpkm for the sample of the runs





    public Integer getSocpdid() {
        return socpdid;
    }

    public void setSocpdid(Integer socpdid) {
        this.socpdid = socpdid;
    }

    public Integer getSampleid() {
        return sample_id;
    }

    public void setSampleid(Integer sampleid) {
        this.sample_id = sampleid;
    }

    public Integer getOrfid() {
        return orf_id;
    }

    public void setOrfid(Integer orfid) {
        this.orf_id = orfid;
    }

    public Double getFpkm() {
        return fpkm;
    }

    public void setFpkm(Double fpkm) {
        this.fpkm = fpkm;
    }

    public Integer getSample_id() {
        return sample_id;
    }

    public void setSample_id(Integer sample_id) {
        this.sample_id = sample_id;
    }

    public String getRun_accession() {
        return run_accession;
    }

    public void setRun_accession(String run_accession) {
        this.run_accession = run_accession;
    }

    public Integer getOrf_id() {
        return orf_id;
    }

    public void setOrf_id(Integer orf_id) {
        this.orf_id = orf_id;
    }
}
