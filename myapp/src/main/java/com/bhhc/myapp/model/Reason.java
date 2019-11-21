package com.bhhc.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reason {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private String company;

    protected Reason() {}

    public Reason(String description, String company) {
        this.description = description;
        this.company = company;
    }

    @Override
    public String toString() {
        return String.format("Reason[id=%d, description='%s', company='%s']",
                id, description, company);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }
}
