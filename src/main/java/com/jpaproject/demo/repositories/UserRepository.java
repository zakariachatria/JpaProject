package com.jpaproject.demo.repositories;

import com.jpaproject.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
public Collection<User> findUsersByPartageListId(Long id);
}
