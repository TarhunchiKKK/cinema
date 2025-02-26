package org.example;

import org.example.seanses.SeansesRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        new SeansesRepository().createBlank();
    }
}