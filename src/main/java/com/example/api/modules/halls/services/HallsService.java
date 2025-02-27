package com.example.api.modules.halls.services;

import java.util.List;

import com.example.api.modules.halls.entities.Hall;
import com.example.api.modules.halls.repositories.HallsRepository;
import com.example.api.modules.halls.utils.SearchHallsQueryBuilder;
import com.example.api.shared.interfaces.IQueryBuilder;

import org.springframework.stereotype.Service;

import com.example.api.modules.halls.dtos.CreateHallRequest;
import com.example.api.modules.halls.dtos.SearchHallsRequest;
import com.example.api.modules.halls.dtos.UpdateHallRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HallsService {
    private final HallsRepository hallsRepository;

    public Hall create(CreateHallRequest request) {
        return this.hallsRepository.save(
                new Hall(request.getType(), request.getSeatsCount()));
    }

    public List<Hall> findAll(SearchHallsRequest request) {
        IQueryBuilder<Hall> queryBuilder = new SearchHallsQueryBuilder(request);
        return this.hallsRepository.findAll(queryBuilder.getExample());
    }

    public void update(Long id, UpdateHallRequest request) {
        Hall hall = this.hallsRepository.findById(id).orElse(null);

        if (hall != null) {
            hall.setType(request.getType());
            hall.setSeatsCount(request.getSeatsCount());
            this.hallsRepository.save(hall);
        }
    }

    public void delete(Long id) {
        Hall hall = this.hallsRepository.findById(id).orElse(null);

        if (hall != null) {
            this.hallsRepository.delete(hall);
        }
    }
}
