package com.jpaproject.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Long id ;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "partageList_id")
    @JsonIgnore
    private PartageList partageList ;



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
    public PartageList getPartageList() {
        return partageList;
    }

    public void setPartageList(PartageList partageList) {
        this.partageList = partageList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", partageList=" + partageList +
                '}';
    }
}
