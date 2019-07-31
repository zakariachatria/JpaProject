package com.jpaproject.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpaproject.demo.models.PartageList;
import com.jpaproject.demo.models.User;
import com.jpaproject.demo.services.PartageListService;
import com.jpaproject.demo.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PartageListService partageListService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    public String saveUser(){
        User user1 =  userService.getUser(1L);

        User user2 =  userService.getUser(2L);
        User user3 =  userService.getUser(3L);

        PartageList partageList = new PartageList("List1" );
        partageList.setUsersList(Arrays.asList(new User[]{user2, user3}));
        partageList.setUser(user1);
        partageListService.SavePartageListe(partageList);
        PartageList partageList2 = new PartageList("List2");
        partageList2.setUsersList(Arrays.asList(new User[] {user1 , user3}));
        partageList2.setUser(user2);
        partageListService.SavePartageListe(partageList2);
        
      

        return "we are users";
    }
    @RequestMapping(value = "/save1" , method = RequestMethod.GET)
    public String saveUsers(){
       List roles = new ArrayList<String>();
       roles.add("ROLE_USER");
        User user1 = new User("zakaria","zakaria.chatria@dxc.com",passwordEncoder.encode("power"), roles);
        userService.saveUser(user1);
        User user2 = new User("youssef","youssef.tiouga@dxc.com",passwordEncoder.encode("power1"), roles);
        userService.saveUser(user2);
        User user3 = new User("adam","adam.mouataz@dxc.com",passwordEncoder.encode("power2"), roles);
        userService.saveUser(user3);
        User user4 = new User("bahaj","bahaj.youssef@dxc.com",passwordEncoder.encode("power3"), roles);
        userService.saveUser(user4);
        User user5 = new User("saad","saad.ouafi@dxc.com",passwordEncoder.encode("power4"), roles);
        userService.saveUser(user5);

        return "we are saved";
    }
    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getUser(id);

        return user;
    }
    @RequestMapping("/getPartage/{id}")
    public PartageList getPartage( @PathVariable Long id)
    {
        return partageListService.getPartageListByUserId(id).get(0);
    }
    
    @RequestMapping("/getAll")
    public List<PartageList> getPartageList()
    {
    	List<PartageList> list = partageListService.getAll();
    	System.out.println(list.get(0).getUser().getName());
    	return list;
    }
    @RequestMapping("/gson")
    public String generateJson(){
        ObjectMapper mapper = new ObjectMapper();
        List roles = new ArrayList<String>();
        roles.add("ROLE_USER");
        User user1 = new User("zakaria","zakaria.chatria@dxc.com",passwordEncoder.encode("power"), roles);

        List<User> objets = new ArrayList<User>();
        objets.add(user1);

        try {
            mapper.writeValue(new File("E:\\Projects\\JpaProject\\file.txt"), objets);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  " done ! ! ";
    }
    @RequestMapping("/getByName/{name}")
    public User getUser(@PathVariable String name){
return  this.userService.getUserByName(name);
    }

    @RequestMapping("/update/{id}/{name}")
    public String UpdateUser(@PathVariable Long id,@PathVariable String name){
        this.userService.updateUser(id,name);
        return  "User Updated !!!";
    }

    }



