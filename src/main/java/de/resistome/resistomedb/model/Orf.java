package de.resistome.resistomedb.model;

import javax.persistence.*;

@Entity
@Table(name="orf", indexes = {
        @Index(name = "IDX1", columnList = "orf_id", unique = true),
        @Index(name="IDX2", columnList = "orf_nt"),
        @Index(name="IDX3", columnList = "orf_pt"),
        @Index(name="IDX4", columnList = "gene"),
        @Index(name="IDX5", columnList = "assembled_region_id"),
        @Index(name="IDX6", columnList="plasflow_phyla")
})
public class Orf {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer orf_id;

    private String orf;


    private String orf_nt;

    private String orf_pt;

    private String plasflow_phyla;

    private String gene;

    public String contig_id;

    public Integer contig_length;

    public String sequence;

    public String deep_arg_gene_id;

    public String label;

    public String plasmid;


    public String cluster_id; // NULL for now - to fill later

    public String isExpressed;

    public Integer taxon_kaiju;

    public String taxon_name_kaiju;

    public String header_ptn_for_phylogeny;

    public String assembled_region_id;


    // TODO function for the name in the newik tree





    public String getPlasflow_phyla() {
        return plasflow_phyla;
    }

    public void setPlasflow_phyla(String plasflow_phyla) {
        this.plasflow_phyla = plasflow_phyla;
    }


    public Integer getOrf_id() {
        return orf_id;
    }

    public void setOrf_id(Integer orf_id) {
        this.orf_id = orf_id;
    }

    public String getOrf() {
        return orf;
    }

    public void setOrf(String orf) {
        this.orf = orf;
    }

    public String getOrf_nt() {
        return orf_nt;
    }

    public void setOrf_nt(String orf_nt) {
        this.orf_nt = orf_nt;
    }

    public String getOrf_pt() {
        return orf_pt;
    }

    public void setOrf_pt(String orf_pt) {
        this.orf_pt = orf_pt;
    }

    public String getCluster_id() {
        return cluster_id;
    }

    public void setCluster_id(String cluster_id) {
        this.cluster_id = cluster_id;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public String getContig_id() {
        return contig_id;
    }

    public void setContig_id(String contig_id) {
        this.contig_id = contig_id;
    }

    public Integer getContig_length() {
        return contig_length;
    }

    public void setContig_length(Integer contig_length) {
        this.contig_length = contig_length;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getDeep_arg_gene_id() {
        return deep_arg_gene_id;
    }

    public void setDeep_arg_gene_id(String deep_arg_gene_id) {
        this.deep_arg_gene_id = deep_arg_gene_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlasmid() {
        return plasmid;
    }

    public void setPlasmid(String plasmid) {
        this.plasmid = plasmid;
    }

    public String getIsExpressed() {
        return isExpressed;
    }

    public void setIsExpressed(String isExpressed) {
        this.isExpressed = isExpressed;
    }

    public Integer getTaxon_kaiju() {
        return taxon_kaiju;
    }

    public void setTaxon_kaiju(Integer taxon_kaiju) {
        this.taxon_kaiju = taxon_kaiju;
    }

    public String getTaxon_name_kaiju() {
        return taxon_name_kaiju;
    }

    public void setTaxon_name_kaiju(String taxon_name_kaiju) {
        this.taxon_name_kaiju = taxon_name_kaiju;
    }

    public String getHeader_ptn_for_phylogeny() {
        return header_ptn_for_phylogeny;
    }

    public void setHeader_ptn_for_phylogeny(String header_ptn_for_phylogeny) {
        this.header_ptn_for_phylogeny = header_ptn_for_phylogeny;
    }

    public String getAssembled_region_id() {
        return assembled_region_id;
    }

    public void setAssembled_region_id(String assembled_region_id) {
        this.assembled_region_id = assembled_region_id;
    }
}
