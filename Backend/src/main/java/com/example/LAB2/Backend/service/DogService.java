package com.example.LAB2.Backend.service;

import com.example.LAB2.Backend.Dog;
import com.example.LAB2.Backend.Repo.DogsRepository;
import com.example.LAB2.Backend.exception.DogExist;
import com.example.LAB2.Backend.exception.DogNotExist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DogService {
    DogsRepository repository;

    public DogService(DogsRepository repository){
        this.repository = repository;
        this.repository.save(new Dog("bogdan",6));
        this.repository.save(new Dog("pawel",7));
        this.repository.save(new Dog("witek",2));
        this.repository.save(new Dog("olo",1));
    }

    public Optional<Dog> getDogByName (String name){
        if (this.repository.findByName(name).isPresent())
            return this.repository.findByName(name);
        else throw new DogNotExist();}
    public ArrayList<Dog> getAllDogs() {
        if (!((ArrayList<Dog>) this.repository.findAll()).isEmpty())
            return (ArrayList<Dog>) this.repository.findAll();
        else throw new DogNotExist();
    }
    public Optional<Dog> addDog(Dog dog){
        if (repository.findByName(dog.getName()).isEmpty())
            return Optional.of(this.repository.save(dog));
        else
            throw new DogExist();
    }
    public void deleteDogByName(String name) {
        var capybara = this.repository.findByName(name);
        if (capybara.isPresent())
            this.repository.delete(capybara.get());
        else
            throw new DogExist();
    }
    public Optional<Dog> updateDogByName(String name, Dog dog1) {
        var dog = this.repository.findByName(name);
        if (dog.isPresent()) {
            if (dog.get().getAge() <= dog1.getAge())
                dog.get().setAge(dog1.getAge());
            return Optional.of(this.repository.save(dog.get()));
        } else {
            throw new DogNotExist();
        }
    }
}
