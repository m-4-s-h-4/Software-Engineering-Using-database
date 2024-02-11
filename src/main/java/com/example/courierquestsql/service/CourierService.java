package com.example.courierquestsql.service;

import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    public ResponseEntity<Courier> addCourier(Courier courier) {
        if (courierRepository.findById(courier.getId()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Courier savedCourier = courierRepository.save(courier);
        return ResponseEntity.ok(savedCourier);
    }

    public ResponseEntity<List<Courier>> getAllCouriers() {
        List<Courier> couriers = courierRepository.findAll();
        if (couriers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(couriers);
    }
}

