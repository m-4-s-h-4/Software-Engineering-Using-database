package com.example.courierquestsql.test.achivment;

import com.example.courierquestsql.controller.AchievementController;
import com.example.courierquestsql.model.Achievement;
import com.example.courierquestsql.service.AchievementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AchievementController.class)
public class AchievementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AchievementService achievementService;

    @Test
    void addOrUpdateAchievement_ReturnsAchievement() throws Exception {
        Achievement achievement = new Achievement();
        given(achievementService.addOrUpdateAchievement(any(String.class), any(Achievement.class))).willReturn(ResponseEntity.ok(achievement));

        mockMvc.perform(post("/couriers/{courierId}/achievements", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"name\":\"Test Achievement\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void getAchievements_ReturnsListOfAchievements() throws Exception {
        List<Achievement> achievements = Arrays.asList(new Achievement(), new Achievement());
        given(achievementService.getAchievements(any(String.class))).willReturn(ResponseEntity.ok(achievements));

        mockMvc.perform(get("/couriers/{courierId}/achievements", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(achievements.size()));
    }
}
