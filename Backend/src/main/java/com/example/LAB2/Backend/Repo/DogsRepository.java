package com.example.LAB2.Backend.Repo;

import com.example.LAB2.Backend.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DogsRepository  extends CrudRepository<Dog, Long> {
    public Optional<Dog> findByName(String name);
}
