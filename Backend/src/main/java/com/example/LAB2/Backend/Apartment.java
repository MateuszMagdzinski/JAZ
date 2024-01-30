package com.example.LAB2.Backend;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private int numberOfRooms;
    private double size;
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dog> dogs = new ArrayList<>();
    public Apartment(String address, int numberOfRooms, double size) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }
    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
        dog.setApartment(this);
    }

    public void removeDog(Dog dog) {
        dogs.remove(dog);
        dog.setApartment(null);
    }

    protected Apartment() {}
}