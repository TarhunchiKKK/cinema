package com.example.api.modules.visitors;

import org.springframework.stereotype.Service;
import com.example.api.modules.visitors.dtos.CreateVisitorRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorsService {
    private final VisitorsRepository visitorRepository;

    public Visitor create(CreateVisitorRequest request) {
        return this.visitorRepository.save(
                new Visitor(request.getFio(), request.getAge(), request.getProfile()));
    }
}
