package com.example.api.modules.visitors.services;

import com.example.api.modules.employees.entities.Employee;
import com.example.api.modules.visitors.entities.Visitor;
import com.example.api.modules.visitors.repositories.VisitorsRepository;
import com.example.api.modules.visitors.utils.SearchVisitorByProfileQueryBuilder;
import com.example.api.shared.interfaces.IQueryBuilder;
import org.springframework.stereotype.Service;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.auth.services.ProfilesService;
import com.example.api.modules.seanses.entities.Seans;
import com.example.api.modules.seanses.services.SeansesService;
import com.example.api.modules.visitors.dtos.CreateVisitorRequest;
import com.example.api.modules.visitors.dtos.ToggleVisitorSeansRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorsService {
    private final VisitorsRepository visitorsRepository;

    private final SeansesService seansesService;

    private final ProfilesService profilesService;

    public Visitor create(CreateVisitorRequest request) {
        return this.visitorsRepository.save(
                new Visitor(request.getFio(), request.getAge(), request.getProfile()));
    }

    public Visitor findByProfileId(Long profileId) {
        return this.visitorsRepository.findByProfileId(profileId);
    }

    public void toggleSeans(ToggleVisitorSeansRequest request) {
        Seans seans = this.seansesService.findOneById(request.getSeansId());

        Profile profile = this.profilesService.findCurrentProfile();

        IQueryBuilder<Visitor> queryBuilder = new SearchVisitorByProfileQueryBuilder(profile);

        Visitor visitor = this.visitorsRepository.findOne(queryBuilder.getExample()).orElse(null);

        if (seans == null || visitor == null) {
            throw new IllegalArgumentException("Invalid seans or visitor ID");
        }

        if (visitor.getSeanses().contains(seans)) {
            visitor.getSeanses().remove(seans);
        } else {
            visitor.getSeanses().add(seans);
        }

        this.visitorsRepository.save(visitor);
    }
}
