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
    private String password;
    @ElementCollection(targetClass=String.class)
    private Collection<String> roles;
//    @ManyToMany
//    @JoinTable(name = "user_partageList22", joinColumns = {
//            @JoinColumn(name = "user", referencedColumnName = "id") }, inverseJoinColumns = {
//                    @JoinColumn(name = "PartageList", referencedColumnName = "id") })
//    private List<PartageList> partageLists ;



    public User() {

    }

    public User(String name, String email, String password, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    //    public List<PartageList> getPartageLists() {
//        return partageLists;
//    }
//
//    public void setPartageLists(List<PartageList> partageLists) {
//        this.partageLists = partageLists;
//    }
}
