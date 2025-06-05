package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.DiscountCouponDTO;
import com.edutech.proyecto.edutech_proyecto.entity.DiscountCoupon;
import com.edutech.proyecto.edutech_proyecto.repository.DiscountCouponRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountCouponService {
    private final DiscountCouponRepository repository;

    public List<DiscountCouponDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(DiscountCouponDTO::fromEntity)
                .toList();
    }

    public DiscountCouponDTO findById(Integer id) {
        DiscountCoupon entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cupón no encontrado con ID: " + id));
        return DiscountCouponDTO.fromEntity(entity);
    }

    public DiscountCouponDTO save(DiscountCouponDTO dto) {
        if (repository.existsByCode(dto.getCode())) {
            throw new IllegalArgumentException("El código de cupón ya existe: " + dto.getCode());
        }
        DiscountCoupon saved = repository.save(DiscountCouponDTO.toEntity(dto));
        return DiscountCouponDTO.fromEntity(saved);
    }

    public DiscountCouponDTO update(Integer id, DiscountCouponDTO dto) {
        DiscountCoupon existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cupón no encontrado con ID: " + id));

        existing.setCode(dto.getCode());
        existing.setDescription(dto.getDescription());
        existing.setDiscountPercentage(dto.getDiscountPercentage());
        existing.setValidFrom(dto.getValidFrom());
        existing.setValidUntil(dto.getValidUntil());
        existing.setIsActive(dto.getIsActive());

        DiscountCoupon updated = repository.save(existing);
        return DiscountCouponDTO.fromEntity(updated);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Cupón no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    public Optional<DiscountCouponDTO> findByCode(String code) {
        return repository.findByCode(code).map(DiscountCouponDTO::fromEntity);
    }

}
