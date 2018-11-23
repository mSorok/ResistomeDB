package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer arg_id;

    private String arg;

    private String arg_description;

    private String arg_family;

    // TODO add long String = newik table = TEXT or BLOB field

    //TODO
}
