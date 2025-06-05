package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
