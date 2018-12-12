package com.jpaproject.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Long id ;
    private String name;
    private String email;
    @ManyToMany

    private List<PartageList> partageLists ;



    public User() {

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PartageList> getPartageLists() {
        return partageLists;
    }

    public void setPartageLists(List<PartageList> partageLists) {
        this.partageLists = partageLists;
    }
}
