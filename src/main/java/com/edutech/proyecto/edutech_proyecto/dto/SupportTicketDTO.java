package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.SupportTicket;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class SupportTicketDTO {

    private Integer id;

    @NotNull(message = "El userId no puede ser nulo")
    private Integer userId;

    private Integer supportUserId;

    @NotNull(message = "El subject no puede ser nulo")
    @Size(max = 200, message = "El subject debe tener máximo 200 caracteres")
    private String subject;

    @NotNull(message = "La descripción no puede ser nula")
    @Size(max = 800, message = "La descripción debe tener máximo 800 caracteres")
    private String description;

    @NotNull(message = "El status no puede ser nulo")
    @Size(max = 20, message = "El status debe tener máximo 20 caracteres")
    private String status;

    private Instant createdAt;

    private Instant closedAt;


    public static SupportTicketDTO fromEntity(SupportTicket entity) {
        if (entity == null) return null;

        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser() != null ? entity.getUser().getId() : null);
        dto.setSupportUserId(entity.getSupportUser() != null ? entity.getSupportUser().getId() : null);
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setClosedAt(entity.getClosedAt());

        return dto;
    }

    public SupportTicket toEntity() {
        SupportTicket entity = new SupportTicket();
        entity.setId(this.getId());
        if (this.getUserId() != null) {
            User user = new User();
            user.setId(this.getUserId());
            entity.setUser(user);
        }
        if (this.getSupportUserId() != null) {
            User supportUser = new User();
            supportUser.setId(this.getSupportUserId());
            entity.setSupportUser(supportUser);
        }
        entity.setSubject(this.getSubject());
        entity.setDescription(this.getDescription());
        entity.setStatus(this.getStatus());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setClosedAt(this.getClosedAt());

        return entity;
    }

}
