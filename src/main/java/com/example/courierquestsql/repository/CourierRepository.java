package com.example.courierquestsql.repository;

import com.example.courierquestsql.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourierRepository extends JpaRepository<Courier, String> {
}

