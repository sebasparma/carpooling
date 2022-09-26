package com.pragma.carpooling.repository;

import com.pragma.carpooling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {

    public User findByEmail(String email);
}
