package com.example.courierquestsql.service;

import com.example.courierquestsql.model.QuestProgress;
import com.example.courierquestsql.repository.CourierRepository;
import com.example.courierquestsql.repository.QuestProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestProgressService {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private QuestProgressRepository questProgressRepository;

    public ResponseEntity<QuestProgress> updateCurrentQuest(String courierId, QuestProgress newQuestProgress) {
        return courierRepository.findById(courierId).map(courier -> {
            Optional<QuestProgress> existingProgressOpt = questProgressRepository.findByCourier(courier);
            QuestProgress existingProgress = existingProgressOpt.orElse(new QuestProgress());
            existingProgress.setCourier(courier);
            existingProgress.setCurrentTier(newQuestProgress.getCurrentTier());
            existingProgress.setNextTier(newQuestProgress.getNextTier());
            existingProgress.setOrdersCompleted(newQuestProgress.getOrdersCompleted());
            existingProgress.setOrdersNeededForNextTier(newQuestProgress.getOrdersNeededForNextTier());
            existingProgress.setRewardForCurrentTier(newQuestProgress.getRewardForCurrentTier());
            existingProgress.setTimeLeftToCompleteTier(newQuestProgress.getTimeLeftToCompleteTier());

            QuestProgress savedQuestProgress = questProgressRepository.save(existingProgress);
            return ResponseEntity.ok(savedQuestProgress);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<QuestProgress> getCurrentQuest(String courierId) {
        return courierRepository.findById(courierId)
                .flatMap(courier -> questProgressRepository.findByCourier(courier))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
