package com.example.LAB2.Backend.Controllers;

import com.example.LAB2.Backend.Dog;
import com.example.LAB2.Backend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dog/{name}")
    public Optional<Dog> getDogByName(@PathVariable("name") String name){
        return this.dogService.getDogByName(name);
    }

    @GetMapping("/dogs")
    public ArrayList<Dog> getAll() {
        return this.dogService.getAllDogs();
    }

    @PostMapping("/dog/add")
    public void addDog(@RequestBody Dog dog){
        this.dogService.addDog(dog);
    }

    @DeleteMapping("/dog/delete/{name}")
    public void deleteByName(@PathVariable("name")String name){
        this.dogService.deleteDogByName(name);
    }

    @PutMapping("dog/update/{name}")
    public Optional<Dog> updateByName(@PathVariable("name")String name, @RequestBody Dog dog){
        return this.dogService.updateDogByName(name, dog);
    }
}
