package com.example.api.films;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;
}
