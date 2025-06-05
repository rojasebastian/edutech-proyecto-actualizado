package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.Payment;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDTO {

    private Integer id;
    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Integer userId;
    @NotNull(message = "La cantidad no puede estar vacío")
    private BigDecimal amount;
    @NotNull(message = "La fecha de pago no puede estar vacía")
    private Instant paymentDate;
    @NotNull(message = "El metodo de pago no puede estar vacío")
    private String paymentMethod;
    @NotNull(message = "La institucion de pago no puede estar vacío")
    private String paymentInstitution;
    @NotNull(message = "El id de transaccion no puede estar vacío")
    private String transactionId;
    @NotNull(message = "El status no puede estar vacío")
    private String status;


    public static PaymentDTO fromEntity(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setUserId(payment.getUser().getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentInstitution(payment.getPaymentInstitution());
        dto.setTransactionId(payment.getTransactionId());
        dto.setStatus(payment.getStatus());
        return dto;
    }


    public static Payment toEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentInstitution(dto.getPaymentInstitution());
        payment.setTransactionId(dto.getTransactionId());
        payment.setStatus(dto.getStatus());
        return payment;
    }
}
