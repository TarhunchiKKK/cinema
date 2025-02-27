package com.example.api.halls;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HallsService {
    private final HallsRepository hallsRepository;
}
