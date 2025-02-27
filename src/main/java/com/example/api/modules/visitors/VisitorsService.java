package com.example.api.modules.visitors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorsService {
    private final VisitorsRepository visitorRepository;
}
