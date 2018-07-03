package com.epam.mentoring.cartservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Position> positions = new ArrayList<>();
    private Long total = 0L;

    public void addPosition(Position position){
        positions.add(position);
        total += position.getCount() * position.getPrice();
    }
}
