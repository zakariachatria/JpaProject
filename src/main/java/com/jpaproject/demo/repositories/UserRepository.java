package com.jpaproject.demo.repositories;

import com.jpaproject.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//public Collection<User> findUsersByPartageListsId(Long id);
    @Query("SELECT u FROM User u where u.name= :name")
    public Collection<User> getByName(@Param("name") String name  );

    @Modifying
    @Query("update User u SET u.name=:name where u.id = :id ")
    public void updateUser( @Param("id") Long id , @Param("name") String name);

    public User findByEmail(String email);
}
