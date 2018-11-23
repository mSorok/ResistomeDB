package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orf {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer orf_id;


    private String orf_nt;

    private String orf_pt;

    //TODO

    private String plasflow_phyla;

    //TODO add is nucleotide or protein

    // TODO add contig id

    // ADD the FASTA

    //TODO add deep_arg_gene_id


    // function for the name in the newik tree


    public String cluster_id; // NULL for now - to fill later








    public String getPlasflow_phyla() {
        return plasflow_phyla;
    }

    public void setPlasflow_phyla(String plasflow_phyla) {
        this.plasflow_phyla = plasflow_phyla;
    }
}
