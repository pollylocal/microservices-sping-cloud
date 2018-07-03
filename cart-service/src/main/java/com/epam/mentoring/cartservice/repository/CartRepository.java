package com.epam.mentoring.cartservice.repository;

import com.epam.mentoring.cartservice.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findById(Long id);
}
