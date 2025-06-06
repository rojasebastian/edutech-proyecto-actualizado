package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.SupportTicketDTO;
import com.edutech.proyecto.edutech_proyecto.entity.SupportTicket;

import com.edutech.proyecto.edutech_proyecto.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportTicketService {
    private final SupportTicketRepository repository;



    public List<SupportTicketDTO> findAll() {
        return repository.findAll().stream()
                .map(SupportTicketDTO::fromEntity)
                .toList();
    }

    public SupportTicketDTO findById(Integer id) {
        return SupportTicketDTO.fromEntity(
                repository.findById(id)
                        .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("SupportTicket no encontrada"))
        );
    }

    public SupportTicketDTO create(SupportTicketDTO dto) {
        return SupportTicketDTO.fromEntity(
                repository.save(dto.toEntity())
        );
    }

    public SupportTicketDTO update(Integer id, SupportTicketDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("SupportTicket no encontrada"));
        SupportTicket entity = dto.toEntity();
        entity.setId(id);
        return SupportTicketDTO.fromEntity(
                repository.save(entity)
        );
    }

    public void delete(Integer id) {
        repository.delete(
                repository.findById(id)
                        .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("SupportTicket no encontrada"))
        );
    }
}
