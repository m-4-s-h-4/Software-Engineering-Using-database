package com.example.courierquestsql.controller;

import com.example.courierquestsql.model.Courier;
import com.example.courierquestsql.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping
    public ResponseEntity<Courier> addCourier(@RequestBody Courier courier) {
        return courierService.addCourier(courier);
    }

    @GetMapping
    public ResponseEntity<List<Courier>> getAllCouriers() {
        return courierService.getAllCouriers();
    }
}
