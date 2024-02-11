package com.example.courierquestsql.service;

import com.example.courierquestsql.model.Achievement;
import com.example.courierquestsql.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public ResponseEntity<Achievement> addOrUpdateAchievement(String courierId, Achievement achievement) {
        achievement.setCourierId(courierId);
        Achievement savedAchievement = achievementRepository.save(achievement);
        return ResponseEntity.ok(savedAchievement);
    }

    public ResponseEntity<List<Achievement>> getAchievements(String courierId) {
        List<Achievement> achievements = achievementRepository.findByCourierId(courierId);
        if (achievements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achievements);
    }
}

