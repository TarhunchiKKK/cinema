package com.example.api.modules.seanses.services;

import com.example.api.modules.seanses.repositories.SeansesRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeansesService {
    private final SeansesRepository seansesRepository;
}
