package com.example.courierquestsql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class QuestProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questProgressId;

    @ManyToOne
    @JoinColumn(name = "courierId")
    private Courier courier;

    private String currentTier;
    private String nextTier;

    private Integer ordersCompleted;
    private Integer ordersNeededForNextTier;
    private Double rewardForCurrentTier;
    private String timeLeftToCompleteTier;
}
