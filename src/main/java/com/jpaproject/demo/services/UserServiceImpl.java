package com.jpaproject.demo.services;

import com.jpaproject.demo.models.User;
import com.jpaproject.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUser(Long id) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional != null)
        {
            user = userOptional.get();
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
     userRepository.save(user);
    }
}
