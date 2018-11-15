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

    private Integer orf_id;

    public Double fpkm;





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
}
