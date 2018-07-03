package com.epam.mentoring.cartservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Long price;
    private Integer count;

    public Position(Product product, PositionRequest positionRequest) {
        this.description = product.getName();
        this.price = product.getPrice();
        this.count = positionRequest.getCount();
    }
}
