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


}
