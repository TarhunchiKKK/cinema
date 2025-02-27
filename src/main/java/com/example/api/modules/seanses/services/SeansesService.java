package com.example.api.modules.seanses.services;

import com.example.api.modules.films.entities.Film;
import com.example.api.modules.films.services.FilmsService;
import com.example.api.modules.halls.entities.Hall;
import com.example.api.modules.halls.services.HallsService;
import com.example.api.modules.seanses.dtos.CreateSeansRequest;
import com.example.api.modules.seanses.entities.Seans;
import com.example.api.modules.seanses.repositories.SeansesRepository;
import com.example.api.modules.seanses.utils.DateParser;
import com.example.api.modules.seanses.utils.SearchSeansesByFilmQueryBuilder;
import com.example.api.shared.interfaces.IQueryBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeansesService {
    private final SeansesRepository seansesRepository;

    private final FilmsService filmsService;

    private final HallsService hallsService;

    public Seans create(CreateSeansRequest request) {
        Film film = this.filmsService.findById(request.getFilmId());
        Hall hall = this.hallsService.findById(request.getHallId());

        if (film == null || hall == null) {
            throw new IllegalArgumentException("Invalid film or hall ID");
        }

        Date date = DateParser.parseDate(request.getDate());
        return this.seansesRepository.save(
                new Seans(date, request.getPrice(), request.getDuration(), film, hall));
    }

    public Seans findOneById(Long id) {
        return this.seansesRepository.findById(id).orElse(null);
    }

    public List<Seans> findAllByFilmId(Long id) {
        Film film = this.filmsService.findById(id);

        if (film == null) {
            return new ArrayList<Seans>();
        }

        IQueryBuilder<Seans> queryBuilder = new SearchSeansesByFilmQueryBuilder(film);
        return this.seansesRepository.findAll(queryBuilder.getExample());
    }
}
