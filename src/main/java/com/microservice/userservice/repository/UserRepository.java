package com.microservice.userservice.repository;

import com.microservice.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, java.lang.String> {
    Users findByEmail(java.lang.String email);
    Users deleteByEmail(String id);
}
