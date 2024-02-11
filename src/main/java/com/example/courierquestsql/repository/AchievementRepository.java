package com.example.courierquestsql.repository;

import com.example.courierquestsql.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByCourierId(String courierId);
}
