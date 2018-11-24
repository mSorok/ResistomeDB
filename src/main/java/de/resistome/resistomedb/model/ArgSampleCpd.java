package de.resistome.resistomedb.model;

import javax.persistence.*;

@Entity
@Table(name="arg_sample_cpd", indexes = {
        @Index(name="IDX1", columnList = "arg_id"),
        @Index(name="IDX2", columnList = "sample_id"),
        @Index(name="IDX3", columnList = "arg_id,sample_id")
})
public class ArgSampleCpd {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ascid;



    private Integer arg_id;

    private Integer sample_id;



}
