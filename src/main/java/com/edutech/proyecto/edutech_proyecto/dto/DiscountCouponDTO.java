package com.edutech.proyecto.edutech_proyecto.dto;


import com.edutech.proyecto.edutech_proyecto.entity.DiscountCoupon;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountCouponDTO {

    private Integer id;

    @NotNull(message = "El código no puede estar vacío")
    @Size(max = 50, message = "El código no puede superar los 50 caracteres")
    private String code;

    @NotNull(message = "La descripción no puede estar vacía")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres")
    private String description;

    @NotNull(message = "El porcentaje de descuento no puede estar vacío")
    private BigDecimal discountPercentage;

    @NotNull(message = "La fecha de inicio no puede estar vacía")
    private LocalDate validFrom;

    @NotNull(message = "La fecha de vencimiento no puede estar vacía")
    private LocalDate validUntil;

    private Boolean isActive = false;



    public static DiscountCouponDTO fromEntity(DiscountCoupon entity) {
        DiscountCouponDTO dto = new DiscountCouponDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidUntil(entity.getValidUntil());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static DiscountCoupon toEntity(DiscountCouponDTO dto) {
        DiscountCoupon entity = new DiscountCoupon();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setDiscountPercentage(dto.getDiscountPercentage());
        entity.setValidFrom(dto.getValidFrom());
        entity.setValidUntil(dto.getValidUntil());
        entity.setIsActive(dto.getIsActive());
        return entity;
    }
}
