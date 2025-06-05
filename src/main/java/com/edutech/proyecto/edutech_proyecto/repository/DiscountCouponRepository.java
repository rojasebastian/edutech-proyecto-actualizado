package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.DiscountCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountCouponRepository extends JpaRepository<DiscountCoupon, Integer> {

    Optional<DiscountCoupon> findByCode(String code);

    boolean existsByCode(String code);

}
