package com.example.courierquestsql.controller;

import com.example.courierquestsql.model.QuestProgress;
import com.example.courierquestsql.service.QuestProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couriers/{courierId}/current-quest")
public class QuestProgressController {

    @Autowired
    private QuestProgressService questProgressService;

    @PostMapping
    public ResponseEntity<QuestProgress> updateCurrentQuest(@PathVariable String courierId, @RequestBody QuestProgress questProgress) {
        return questProgressService.updateCurrentQuest(courierId, questProgress);
    }

    @GetMapping
    public ResponseEntity<QuestProgress> getCurrentQuest(@PathVariable String courierId) {
        return questProgressService.getCurrentQuest(courierId);
    }
}

