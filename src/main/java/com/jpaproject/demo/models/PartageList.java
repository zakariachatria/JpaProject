package com.jpaproject.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PartageList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String label ;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user ;

   

	@ManyToMany
    @JoinTable(name = "partageList_user22", joinColumns = {
            @JoinColumn(name = "PartageList", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user", referencedColumnName = "id") })
    private List<User> usersList ;




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

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
