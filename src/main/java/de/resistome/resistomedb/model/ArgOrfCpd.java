package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArgOrfCpd {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer aocpdid;

    private Integer orf_id;

    private Integer arg_id;

    private Integer query_start;

    private Integer query_end;

    private String predicted_arg; // predicted_ARG-class

    private String best_hit; // best-hit

    private Double probability;

    private Double identity;

    private Integer alignment_length;

    private Double alignment_bitscore;

    private Double alignment_evalue;

    private Integer problematic_classification;




    //			sample	gene	contig_id	ptn_id	contig_length	plasmid	Plasflow_phyla	read_id	taxon_kaiju	taxon_name_kaiju


    public Integer getAocpdid() {
        return aocpdid;
    }

    public void setAocpdid(Integer aocpdid) {
        this.aocpdid = aocpdid;
    }

    public Integer getOrf_id() {
        return orf_id;
    }

    public void setOrf_id(Integer orf_id) {
        this.orf_id = orf_id;
    }

    public Integer getArg_id() {
        return arg_id;
    }

    public void setArg_id(Integer arg_id) {
        this.arg_id = arg_id;
    }

    public Integer getQuery_start() {
        return query_start;
    }

    public void setQuery_start(Integer query_start) {
        this.query_start = query_start;
    }

    public Integer getQuery_end() {
        return query_end;
    }

    public void setQuery_end(Integer query_end) {
        this.query_end = query_end;
    }

    public String getPredicted_arg() {
        return predicted_arg;
    }

    public void setPredicted_arg(String predicted_arg) {
        this.predicted_arg = predicted_arg;
    }

    public String getBest_hit() {
        return best_hit;
    }

    public void setBest_hit(String best_hit) {
        this.best_hit = best_hit;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Double getIdentity() {
        return identity;
    }

    public void setIdentity(Double identity) {
        this.identity = identity;
    }

    public Integer getAlignment_length() {
        return alignment_length;
    }

    public void setAlignment_length(Integer alignment_length) {
        this.alignment_length = alignment_length;
    }

    public Double getAlignment_bitscore() {
        return alignment_bitscore;
    }

    public void setAlignment_bitscore(Double alignment_bitscore) {
        this.alignment_bitscore = alignment_bitscore;
    }

    public Double getAlignment_evalue() {
        return alignment_evalue;
    }

    public void setAlignment_evalue(Double alignment_evalue) {
        this.alignment_evalue = alignment_evalue;
    }

    public Integer getProblematic_classification() {
        return problematic_classification;
    }

    public void setProblematic_classification(Integer problematic_classification) {
        this.problematic_classification = problematic_classification;
    }
}
