package de.resistome.resistomedb.model;


import javax.persistence.*;

@Entity
@Table(name="arg_class_sample_cpd", indexes = {
        @Index(name = "IDX1", columnList = "arg_class_id"),
        @Index(name="IDX2", columnList = "sample_id")
})
public class ArgClassSampleCpd {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer acscpd_id;

    private Integer arg_class_id;

    private Integer sample_id;

    //TODO add more parameters


    public Integer getAcscpd_id() {
        return acscpd_id;
    }

    public void setAcscpd_id(Integer acscpd_id) {
        this.acscpd_id = acscpd_id;
    }

    public Integer getArg_class_id() {
        return arg_class_id;
    }

    public void setArg_class_id(Integer arg_class_id) {
        this.arg_class_id = arg_class_id;
    }

    public Integer getSample_id() {
        return sample_id;
    }

    public void setSample_id(Integer sample_id) {
        this.sample_id = sample_id;
    }
}
