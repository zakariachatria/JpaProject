package com.jpaproject.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class PartageList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String label ;
    @OneToMany( mappedBy = "partageList")

    private Collection<User> usersList ;
    @Transient
    private List<UserInter> userInters;



    public PartageList() {

    }


    public PartageList( String label) {

        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Collection<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Collection<User> usersList) {
        this.usersList = usersList;
    }
    public Collection<UserInter> getUserInters() {
        return userInters;
    }

    public void setUserInters(List<UserInter> userInters) {
        this.userInters = userInters;
    }
}
