package com.epam.mentoring.cartservice.controller;

import com.epam.mentoring.cartservice.domain.Cart;
import com.epam.mentoring.cartservice.repository.CartRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping
    public Cart createCart(){
        return cartRepository.save(new Cart());
    }

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId){
        return cartRepository.getOne(cartId);
    }
}
