package com.jpaproject.demo.services;

import com.jpaproject.demo.models.User;
import com.jpaproject.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public static String ROLE = "ROLE_";
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if(user == null)
        {
            throw new UsernameNotFoundException(String.format("this email does not exist ! "));
        }
        user.getRoles().forEach(roleName -> grantedAuthorityList.add(new SimpleGrantedAuthority(ROLE+roleName)));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),grantedAuthorityList);
        return userDetails;
    }
}
