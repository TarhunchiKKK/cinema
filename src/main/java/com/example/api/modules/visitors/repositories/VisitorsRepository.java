package com.example.api.modules.visitors.repositories;

import com.example.api.modules.visitors.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorsRepository extends JpaRepository<Visitor, Long> {
    Visitor findByProfileId(Long profileId);
}
