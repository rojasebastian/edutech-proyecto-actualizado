package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.DiscountCouponDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-discount-coupon", url = "http://localhost:8080/api/discount-coupon")
public interface DiscountCouponClient {


    @GetMapping
    List<DiscountCouponDTO> findAll();

    @GetMapping("/{id}")
    DiscountCouponDTO findById(@PathVariable("id") Integer id);

    @GetMapping("/code/{code}")
    DiscountCouponDTO findByCode(@PathVariable("code") String code);

    @PostMapping
    DiscountCouponDTO save(@RequestBody DiscountCouponDTO dto);

    @PutMapping("/{id}")
    DiscountCouponDTO update(@PathVariable("id") Integer id, @RequestBody DiscountCouponDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

}
