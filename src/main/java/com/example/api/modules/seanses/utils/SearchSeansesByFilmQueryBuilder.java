package com.example.api.modules.seanses.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.example.api.modules.films.entities.Film;
import com.example.api.modules.seanses.entities.Seans;
import com.example.api.shared.interfaces.IQueryBuilder;

public class SearchSeansesByFilmQueryBuilder implements IQueryBuilder<Seans> {
    private Seans probe = new Seans();

    private ExampleMatcher matcher = ExampleMatcher.matching();

    public SearchSeansesByFilmQueryBuilder(Film film) {
        this.setFilm(film);
    }

    private void setFilm(Film film) {
        if (film != null) {
            this.matcher = this.matcher.withMatcher("film", ExampleMatcher.GenericPropertyMatchers.exact());
            this.probe.setFilm(film);
        }
    }

    public Example<Seans> getExample() {
        return Example.of(this.probe, this.matcher);
    }
}
