package com.example.courierquestsql.test.quest;

import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.model.QuestProgress;
import com.example.courierquestsql.repository.CourierRepository;
import com.example.courierquestsql.repository.QuestProgressRepository;
import com.example.courierquestsql.service.QuestProgressService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuestProgressServiceTest {

    @Mock
    private CourierRepository courierRepository;

    @Mock
    private QuestProgressRepository questProgressRepository;

    @InjectMocks
    private QuestProgressService questProgressService;

    @Test
    void updateCurrentQuest_ReturnsUpdatedQuestProgress() {
        QuestProgress newQuestProgress = new QuestProgress();
        Courier mockCourier = new Courier();

        when(courierRepository.findById(any())).thenReturn(Optional.of(mockCourier));
        when(questProgressRepository.findByCourier(any())).thenReturn(Optional.of(newQuestProgress));
        when(questProgressRepository.save(any(QuestProgress.class))).thenReturn(newQuestProgress);

        ResponseEntity<QuestProgress> response = questProgressService.updateCurrentQuest("courierId", newQuestProgress);

        assertThat(response.getStatusCode().value()
) .isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void getCurrentQuest_WhenFound_ReturnsQuestProgress() {
        QuestProgress existingQuestProgress = new QuestProgress();
        Courier mockCourier = new Courier();

        when(courierRepository.findById(any())).thenReturn(Optional.of(mockCourier));
        when(questProgressRepository.findByCourier(any())).thenReturn(Optional.of(existingQuestProgress));

        ResponseEntity<QuestProgress> response = questProgressService.getCurrentQuest("courierId");

        assertThat(response.getStatusCode().value()
) .isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void getCurrentQuest_WhenNotFound_ReturnsNotFound() {
        when(courierRepository.findById(any())).thenReturn(Optional.empty());

        ResponseEntity<QuestProgress> response = questProgressService.getCurrentQuest("courierId");

        assertThat(response.getStatusCode()).isEqualTo(ResponseEntity.notFound().build().getStatusCode());
    }
}
