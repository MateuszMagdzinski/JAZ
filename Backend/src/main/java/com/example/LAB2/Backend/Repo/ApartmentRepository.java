package com.example.LAB2.Backend.Repo;

import com.example.LAB2.Backend.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}