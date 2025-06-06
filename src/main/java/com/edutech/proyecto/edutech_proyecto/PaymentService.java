package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.PaymentDTO;
import com.edutech.proyecto.edutech_proyecto.entity.Payment;

import com.edutech.proyecto.edutech_proyecto.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;

    public List<PaymentDTO> findAll() {
        return repository.findAll().stream()
                .map(PaymentDTO::fromEntity)
                .toList();
    }

    public PaymentDTO findById(Integer id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Pago no encontrado"));
        return PaymentDTO.fromEntity(payment);
    }

    public PaymentDTO create(PaymentDTO dto) {
        Payment payment = PaymentDTO.toEntity(dto);
        return PaymentDTO.fromEntity(repository.save(payment));
    }

    public PaymentDTO update(Integer id, PaymentDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Pago no encontrado"));
        Payment payment = PaymentDTO.toEntity(dto);
        payment.setId(id);
        return PaymentDTO.fromEntity(repository.save(payment));
    }

    public void delete(Integer id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Pago no encontrado"));
        repository.delete(payment);
    }

}
