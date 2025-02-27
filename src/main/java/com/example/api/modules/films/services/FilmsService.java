package com.example.api.modules.films.services;

import java.util.List;

import com.example.api.modules.films.entities.Film;
import com.example.api.modules.films.repositories.FilmsRepository;
import org.springframework.stereotype.Service;

import com.example.api.modules.films.dtos.CreateFilmRequest;
import com.example.api.modules.films.dtos.UpdateFilmRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;

    public Film create(CreateFilmRequest request) {
        return this.filmsRepository.save(
                new Film(request.getTitle(), request.getYear(), request.getCountry()));
    }

    public List<Film> findAll() {
        return this.filmsRepository.findAll();
    }

    public void update(Long id, UpdateFilmRequest request) {
        Film film = this.filmsRepository.findById(id).orElse(null);

        if (film != null) {
            film.setTitle(request.getTitle());
            film.setYear(request.getYear());
            film.setCountry(request.getCountry());
            this.filmsRepository.save(film);
        }
    }

    public void delete(Long id) {
        Film film = this.filmsRepository.findById(id).orElse(null);

        if (film != null) {
            this.filmsRepository.delete(film);
        }
    }
}
