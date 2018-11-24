package de.resistome.resistomedb.model;


import javax.persistence.*;

@Entity
@Table(name="arg_class", indexes = {
        @Index(name = "IDX1", columnList = "arg_class_id", unique = true),
        @Index(name = "IDX2", columnList = "arg_class_name", unique = true)
})
public class ArgClass {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer arg_class_id;

    private String arg_class_name;

    private String arg_class_description;


    public Integer getArg_class_id() {
        return arg_class_id;
    }

    public void setArg_class_id(Integer arg_class_id) {
        this.arg_class_id = arg_class_id;
    }

    public String getArg_class_name() {
        return arg_class_name;
    }

    public void setArg_class_name(String arg_class_name) {
        this.arg_class_name = arg_class_name;
    }

    public String getArg_class_description() {
        return arg_class_description;
    }

    public void setArg_class_description(String arg_class_description) {
        this.arg_class_description = arg_class_description;
    }
}
