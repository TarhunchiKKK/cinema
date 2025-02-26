package org.example;

import org.example.films.FilmsRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        new FilmsRepository().delete(1l);
        ;
    }
}