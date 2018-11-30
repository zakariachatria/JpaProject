package com.jpaproject.demo.services;

import com.jpaproject.demo.models.User;
import com.jpaproject.demo.models.UserInter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserConverterImpl implements UserConverter {
    @Override
    public Collection<UserInter> convert(Collection<User> users) {
        Collection<UserInter> userInters = new ArrayList<>();
        for (User user : users){
            ((ArrayList<UserInter>) userInters).add(conve(user));
        }
        return userInters;
    }

    private UserInter conve(User user) {
        UserInter userInter = new UserInter();
        userInter.setId(user.getId());
        userInter.setEmail(user.getEmail());
        userInter.setName(user.getName());
        return userInter;
    }
}
