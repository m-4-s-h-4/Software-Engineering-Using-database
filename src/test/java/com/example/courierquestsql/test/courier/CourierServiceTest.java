package com.example.courierquestsql.test.courier;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.repository.CourierRepository;
import com.example.courierquestsql.service.CourierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CourierServiceTest {

    @Mock
    private CourierRepository courierRepository;

    @InjectMocks
    private CourierService courierService;

    @Test
    void addCourier_NewCourier_ReturnsSavedCourier() {
        Courier courier = new Courier();
        given(courierRepository.findById(any())).willReturn(Optional.empty());
        given(courierRepository.save(any(Courier.class))).willReturn(courier);

        ResponseEntity<Courier> response = courierService.addCourier(courier);

        assertThat(response.getStatusCode().value()
).isEqualTo(200);
        assertThat(response.getBody()).isSameAs(courier);
    }

    @Test
    void getAllCouriers_CouriersExist_ReturnsListOfCouriers() {
        List<Courier> couriers = Arrays.asList(new Courier(), new Courier());
        given(courierRepository.findAll()).willReturn(couriers);

        ResponseEntity<List<Courier>> response = courierService.getAllCouriers();

        assertThat(response.getStatusCode().value()
).isEqualTo(200);
        assertThat(response.getBody()).hasSize(couriers.size());
    }
}
