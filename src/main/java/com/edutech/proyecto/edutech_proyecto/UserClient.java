package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-user", url = "http://localhost:3306/api/user")
public interface UserClient {


    @GetMapping
    List<UserDTO> getAllUsers();

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable("id") Integer id);

    @PostMapping
    UserDTO createUser(@RequestBody UserDTO userDTO);

    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") Integer id);
}
