package com.example.courierquestsql.controller;

import com.example.courierquestsql.model.Achievement;
import com.example.courierquestsql.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers/{courierId}/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @PostMapping
    public ResponseEntity<Achievement> addOrUpdateAchievement(@PathVariable String courierId, @RequestBody Achievement achievement) {
        return achievementService.addOrUpdateAchievement(courierId, achievement);
    }

    @GetMapping
    public ResponseEntity<List<Achievement>> getAchievements(@PathVariable String courierId) {
        return achievementService.getAchievements(courierId);
    }
}

