package de.resistome.resistomedb.model;

import javax.persistence.*;

@Entity
@Table(name="sample", indexes = {  @Index(name = "IDX1", columnList = "sampleid", unique = true)} )
public class Sample {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String sampleid;

    //TODO fill in the fields



}
