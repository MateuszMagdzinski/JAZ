package com.example.LAB2.Backend.service;

import com.example.LAB2.Backend.Apartment;
import com.example.LAB2.Backend.Repo.ApartmentRepository;
import com.example.LAB2.Backend.exception.ApartmentNotExist;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ApartmentService {
    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository){
        this.repository = repository;
    }

    public Optional<Apartment> getApartmentById(Long id){
        return this.repository.findById(id);
    }

    public ArrayList<Apartment> getAllApartments() {
        return (ArrayList<Apartment>) this.repository.findAll();
    }

    public Apartment addApartment(Apartment apartment){
        return this.repository.save(apartment);
    }

    public void deleteApartment(Long id) {
        var apartment = this.repository.findById(id);
        if (apartment.isPresent())
            this.repository.delete(apartment.get());
        else
            throw new ApartmentNotExist();
    }

}