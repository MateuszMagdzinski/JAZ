package com.example.LAB2.Backend.exception;

public class DogNotExist extends NullPointerException{
    public DogNotExist(){super("Kot juz istnieje");}
}
