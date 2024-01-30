package com.example.LAB2.Backend;

import jakarta.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName () {
        return name;
    }
    public int getAge () {
        return age;
    }
    public void setAge ( int age){
        this.age = age;
    }
    public void setName (String name){
        this.name = name;
    }
    public Long getId () {
        return id;
    }
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
    protected Dog() {}

}
