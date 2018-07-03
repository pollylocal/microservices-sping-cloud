package com.epam.mentoring.cartservice.controller;

import com.epam.mentoring.cartservice.client.ProductCatalogClient;
import com.epam.mentoring.cartservice.domain.Position;
import com.epam.mentoring.cartservice.domain.PositionRequest;
import com.epam.mentoring.cartservice.domain.Product;
import com.epam.mentoring.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts/{cartID}/positions")
public class PositionController {
    private final CartService cartService;
    private final ProductCatalogClient productCatalogClient;


    public PositionController(CartService cartService, ProductCatalogClient productCatalogClient) {
        this.cartService = cartService;
        this.productCatalogClient = productCatalogClient;
    }

    @PostMapping
    public Position createPosition(@PathVariable Long cartID, @RequestBody PositionRequest positionRequest){
        Product product = productCatalogClient.getProduct(positionRequest.getProductId()).getContent();
        Position position = new Position(product, positionRequest);
        cartService.addPosition(cartID, position);
        return position;
    }
}
