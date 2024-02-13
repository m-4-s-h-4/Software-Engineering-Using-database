package com.example.courierquestsql.test.achivment;

import com.example.courierquestsql.model.Achievement;
import com.example.courierquestsql.repository.AchievementRepository;
import com.example.courierquestsql.service.AchievementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AchievementServiceTest {

    @Mock
    private AchievementRepository achievementRepository;

    @InjectMocks
    private AchievementService achievementService;

    @Test
    void addOrUpdateAchievement_ReturnsSavedAchievement() {
        Achievement achievement = new Achievement();
        given(achievementRepository.save(any(Achievement.class))).willReturn(achievement);

        ResponseEntity<Achievement> response = achievementService.addOrUpdateAchievement("courierId", achievement);

        assertThat(response.getStatusCode().value()
).isEqualTo(200);
        assertThat(response.getBody()).isSameAs(achievement);
    }

    @Test
    void getAchievements_WhenExist_ReturnsListOfAchievements() {
        List<Achievement> achievements = Arrays.asList(new Achievement(), new Achievement());
        given(achievementRepository.findByCourierId(any(String.class))).willReturn(achievements);

        ResponseEntity<List<Achievement>> response = achievementService.getAchievements("courierId");

        assertThat(response.getStatusCode().value()
).isEqualTo(200);
        assertThat(response.getBody()).hasSize(achievements.size());
    }

    @Test
    void getAchievements_WhenNotExist_ReturnsNotFound() {
        given(achievementRepository.findByCourierId(any(String.class))).willReturn(Collections.emptyList());

        ResponseEntity<List<Achievement>> response = achievementService.getAchievements("courierId");

        assertThat(response.getStatusCode()).isEqualTo(ResponseEntity.notFound().build().getStatusCode());
    }
}

