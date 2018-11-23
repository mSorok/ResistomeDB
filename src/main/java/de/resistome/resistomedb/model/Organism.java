package de.resistome.resistomedb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organism {

    @Id
    private Integer tax_id;

    private String tax_name;

    private Integer kaiju_tax_id;

}
