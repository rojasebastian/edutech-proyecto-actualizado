package com.edutech.proyecto.edutech_proyecto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-support-ticket", url = "http://localhost:8080/api/support-ticket")
public interface SupportTicketClient {


    @GetMapping
    List<Object> getAllSupportTickets();

    @GetMapping("/{id}")
    Object getSupportTicketById(@PathVariable("id") Integer id);

    @GetMapping("/user/{userId}")
    List<Object> getSupportTicketsByUserId(@PathVariable("userId") Integer userId);

    @GetMapping("/supportUser/{supportUserId}")
    List<Object> getSupportTicketsBySupportUserId(@PathVariable("supportUserId") Integer supportUserId);

    @GetMapping("/status/{status}")
    List<Object> getSupportTicketsByStatus(@PathVariable("status") String status);

    @PostMapping
    Object createSupportTicket(@RequestBody Object supportTicketDTO);

    @PutMapping("/{id}")
    Object updateSupportTicket(@PathVariable("id") Integer id, @RequestBody Object supportTicketDTO);

    @DeleteMapping("/{id}")
    void deleteSupportTicket(@PathVariable("id") Integer id);
}
