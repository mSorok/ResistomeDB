package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArgSampleCpd {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ascid;



    private Integer arg_id;

    private Integer sample_id;



}
