package com.example.api.seanses;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeansesService {
    private final SeansesRepository seansesRepository;
}
