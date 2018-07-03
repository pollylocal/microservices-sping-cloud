package com.epam.mentoring.cartservice.service;

import com.epam.mentoring.cartservice.domain.Cart;
import com.epam.mentoring.cartservice.domain.Position;
import com.epam.mentoring.cartservice.exceptions.CartNotFoundException;
import com.epam.mentoring.cartservice.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService( CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addPosition(Long cartID, Position position) {
        Cart cart = cartRepository.findById(cartID).orElseThrow(CartNotFoundException::new);
        cart.addPosition(position);
        cartRepository.saveAndFlush(cart);
    }
}
