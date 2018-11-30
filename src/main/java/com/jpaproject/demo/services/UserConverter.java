package com.jpaproject.demo.services;

import com.jpaproject.demo.models.User;
import com.jpaproject.demo.models.UserInter;

import java.util.Collection;

public interface UserConverter {
    Collection<UserInter> convert(Collection<User> users);
}
