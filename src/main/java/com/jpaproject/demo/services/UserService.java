package com.jpaproject.demo.services;

import com.jpaproject.demo.models.User;
import com.jpaproject.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
public User getUser(Long id);
public void saveUser(User user);
}
