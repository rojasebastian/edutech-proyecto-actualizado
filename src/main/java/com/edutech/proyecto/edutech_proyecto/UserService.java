package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.UserDTO;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import com.edutech.proyecto.edutech_proyecto.repository.RoleRepository;
import com.edutech.proyecto.edutech_proyecto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<UserDTO> findAll() {
        return repository.findAll().stream()
                .map(UserDTO::fromEntity)
                .toList();
    }
    public UserDTO findById(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Usuario no encontrado"));
        return UserDTO.fromEntity(user);
    }

    public UserDTO create(UserDTO dto) {
        User user = dto.toEntity();
        return UserDTO.fromEntity(repository.save(user));
    }

    public UserDTO update(Integer id, UserDTO dto) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Usuario no encontrado"));

        User updatedUser = dto.toEntity();
        updatedUser.setId(id);
        updatedUser.setCreatedAt(existing.getCreatedAt());
        updatedUser.setRole(existing.getRole());

        return UserDTO.fromEntity(repository.save(updatedUser));
    }

    public void delete(Integer id) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Usuario no encontrado"));
        repository.delete(existing);
    }
}
