package com.epam.mentoring.cartservice.domain;

import lombok.Data;

@Data
public class PositionRequest {
    private Long productId;
    private Integer count;
}
