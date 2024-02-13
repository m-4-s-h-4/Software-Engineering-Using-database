package com.example.courierquestsql.test.courier;

import com.example.courierquestsql.controller.CourierController;
import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.service.CourierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourierController.class)
public class CourierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourierService courierService;

    @Test
    void addCourier_ReturnsCourier() throws Exception {
        Courier courier = new Courier();
        given(courierService.addCourier(any(Courier.class))).willReturn(ResponseEntity.ok(courier));

        mockMvc.perform(post("/couriers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"name\":\"Test Courier\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllCouriers_ReturnsListOfCouriers() throws Exception {
        List<Courier> couriers = Arrays.asList(new Courier(), new Courier());
        given(courierService.getAllCouriers()).willReturn(ResponseEntity.ok(couriers));

        mockMvc.perform(get("/couriers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(couriers.size()));
    }
}

