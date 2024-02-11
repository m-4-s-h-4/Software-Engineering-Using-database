package com.example.courierquestsql.repository;

import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.model.QuestProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface QuestProgressRepository extends JpaRepository<QuestProgress, Integer> {
    Optional<QuestProgress> findByCourier(Courier courier);
}
