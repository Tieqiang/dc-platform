package com.dchealth.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name="generator",strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
