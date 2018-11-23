package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Xref {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer xref_id;

    private Integer local_id;

    private String local_table;


    private String public_id;

    private String public_db;


    public Integer getXref_id() {
        return xref_id;
    }

    public void setXref_id(Integer xref_id) {
        this.xref_id = xref_id;
    }

    public Integer getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Integer local_id) {
        this.local_id = local_id;
    }

    public String getLocal_table() {
        return local_table;
    }

    public void setLocal_table(String local_table) {
        this.local_table = local_table;
    }

    public String getPublic_id() {
        return public_id;
    }

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }

    public String getPublic_db() {
        return public_db;
    }

    public void setPublic_db(String public_db) {
        this.public_db = public_db;
    }
}
