package com.example.LAB2.Backend.controller;

import com.example.LAB2.Backend.Apartment;
import com.example.LAB2.Backend.Cat;
import com.example.LAB2.Backend.Dog;
import com.example.LAB2.Backend.service.ApartmentService;
import com.example.LAB2.Backend.service.CatService;
import com.example.LAB2.Backend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyController {

    private final ApartmentService apartmentService;
    private final CatService catService;
    private final DogService dogService;

    @Autowired
    public MyController(ApartmentService apartmentService, CatService catService, DogService dogService) {
        this.apartmentService = apartmentService;
        this.catService = catService;
        this.dogService = dogService;
    }

    // Endpointy dla Apartamentów
    @GetMapping("/apartments/{id}")
    public Optional<Apartment> getApartmentById(@PathVariable Long id) {
        return apartmentService.getApartmentById(id);
    }

    @GetMapping("/apartments")
    public ArrayList<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @PostMapping("/apartments")
    public Apartment addApartment(@RequestBody Apartment apartment) {
        return apartmentService.addApartment(apartment);
    }

    @DeleteMapping("/apartments/{id}")
    public void deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
    }

    // Endpointy dla Kotów
    @GetMapping("/cats/{name}")
    public Optional<Cat> getCatByName(@PathVariable String name) {
        return catService.getCatByName(name);
    }

    @GetMapping("/cats")
    public ArrayList<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @PostMapping("/cats")
    public Optional<Cat> addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @DeleteMapping("/cats/{name}")
    public void deleteCatByName(@PathVariable String name) {
        catService.deleteCatByName(name);
    }

    @PutMapping("/cats/{name}")
    public Optional<Cat> updateCatByName(@PathVariable String name, @RequestBody Cat cat1) {
        return catService.updateCatByName(name, cat1);
    }

    // Endpointy dla Psów
    @GetMapping("/dogs/{name}")
    public Optional<Dog> getDogByName(@PathVariable String name) {
        return dogService.getDogByName(name);
    }

    @GetMapping("/dogs")
    public ArrayList<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @PostMapping("/dogs")
    public Optional<Dog> addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @DeleteMapping("/dogs/{name}")
    public void deleteDogByName(@PathVariable String name) {
        dogService.deleteDogByName(name);
    }

    @PutMapping("/dogs/{name}")
    public Optional<Dog> updateDogByName(@PathVariable String name, @RequestBody Dog dog1) {
        return dogService.updateDogByName(name, dog1);
    }
}
