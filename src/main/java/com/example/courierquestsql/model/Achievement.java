package com.example.courierquestsql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courierId;
    private int totalDeliveries;
    private double totalEarnings;
    private String currentTier;
    private int ordersLeftForNextTier;
    public Achievement() {}

}
