package com.jpaproject.demo.controllers;

import com.jpaproject.demo.models.PartageList;
import com.jpaproject.demo.models.User;
import com.jpaproject.demo.services.PartageListService;
import com.jpaproject.demo.services.UserConverter;
import com.jpaproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PartageListService partageListService;
    @Autowired
    UserConverter userConverter;
    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    public String saveUser(){
        User user1 =  userService.getUser(1L);

        User user2 =  userService.getUser(2L);
        User user3 =  userService.getUser(3L);

        PartageList partageList = new PartageList("users1" );

        partageList.setUsersList(Arrays.asList(new User[]{user2, user3}));
        //partageList.setUserInters(userConverter.convert(Arrays.asList(new User[]{user2, user3})));
        partageListService.SavePartageListe(partageList);

       user1.setPartageList(partageList);
        userService.saveUser(user1);

        return "we are users";
    }
    @RequestMapping(value = "/save1" , method = RequestMethod.GET)
    public String saveUsers(){
        User user1 = new User("zakria","zakaria.chatria@dxc.com");
        userService.saveUser(user1);
        User user2 = new User("youssef","youssef.tiouga@dxc.com");
        userService.saveUser(user2);
        User user3 = new User("adam","adam.mouataz@dxc.com");
        userService.saveUser(user3);
        User user4 = new User("bahaj","bahaj.youssef@dxc.com");
        userService.saveUser(user4);
        User user5 = new User("saad","saad.ouafi@dxc.com");
        userService.saveUser(user5);

        return "we are saved";
    }
    @RequestMapping("/getUser/{id}")
    public PartageList getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        List<User> users = (List<User>) user.getPartageList().getUsersList();

        return user.getPartageList();
    }
    @RequestMapping("/getPartage/{id}")
    public PartageList getPartage( @PathVariable Long id)
    {
        return partageListService.getPartageList(id);
    }


}
