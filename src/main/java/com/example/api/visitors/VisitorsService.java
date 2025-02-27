package com.example.api.visitors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorsService {
    private final VisitorsRepository visitorRepository;
}
