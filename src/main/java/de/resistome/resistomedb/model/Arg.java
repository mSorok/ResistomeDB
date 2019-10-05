package de.resistome.resistomedb.model;

import javax.persistence.*;

@Entity
@Table(name="arg", indexes = {
        @Index(name = "IDX1", columnList = "arg_id", unique=true),
        @Index(name="IDX2", columnList = "arg" , unique=true),
        @Index(name="IDX3", columnList = "arg_class_name" ),
        @Index(name="IDX4", columnList = "scenario")
})
public class Arg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer arg_id;

    private String arg;

    private String arg_description;

    private String arg_class_name;

    @Column(name="newik", columnDefinition="TEXT")
    private String newik;

    private String quantification;

    private String scenario;


    public Integer getArg_id() {
        return arg_id;
    }

    public void setArg_id(Integer arg_id) {
        this.arg_id = arg_id;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public String getArg_description() {
        return arg_description;
    }

    public void setArg_description(String arg_description) {
        this.arg_description = arg_description;
    }

    public String getArg_class_name() {
        return arg_class_name;
    }

    public void setArg_class_name(String arg_class_name) {
        this.arg_class_name = arg_class_name;
    }

    public String getNewik() {
        return newik;
    }

    public void setNewik(String newik) {
        this.newik = newik;
    }

    public String getQuantification() {
        return quantification;
    }

    public void setQuantification(String quantification) {
        this.quantification = quantification;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
}
