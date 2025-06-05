package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Integer> {

    List<SupportTicket> findByUserId(Integer userId);
    List<SupportTicket> findBySupportUserId(Integer supportUserId);
    List<SupportTicket> findByStatus(String status);
}
