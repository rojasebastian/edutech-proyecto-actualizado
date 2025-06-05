package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByIsActive(Boolean isActive);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
