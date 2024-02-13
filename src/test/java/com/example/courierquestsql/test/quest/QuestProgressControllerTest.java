package com.example.courierquestsql.test.quest;

import com.example.courierquestsql.controller.QuestProgressController;
import com.example.courierquestsql.model.QuestProgress;
import com.example.courierquestsql.service.QuestProgressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuestProgressController.class)
public class QuestProgressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestProgressService questProgressService;

    @Test
    void updateCurrentQuest_ReturnsQuestProgress() throws Exception {
        QuestProgress questProgress = new QuestProgress();
        given(questProgressService.updateCurrentQuest(any(String.class), any(QuestProgress.class))).willReturn(ResponseEntity.ok(questProgress));

        mockMvc.perform(post("/couriers/{courierId}/current-quest", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"currentTier\":\"1\", \"nextTier\":\"2\"}"))
                .andExpect(status().isOk());
    }
    @Test
    void getCurrentQuest_ReturnsQuestProgress() throws Exception {
        QuestProgress questProgress = new QuestProgress();
        given(questProgressService.getCurrentQuest(any(String.class))).willReturn(ResponseEntity.ok(questProgress));

        mockMvc.perform(get("/couriers/{courierId}/current-quest", "1"))
                .andExpect(status().isOk());
    }
}
