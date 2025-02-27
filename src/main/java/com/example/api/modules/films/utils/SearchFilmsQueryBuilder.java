package com.example.api.modules.films.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.example.api.modules.films.dtos.SearchFilmsRequest;
import com.example.api.modules.films.entities.Film;
import com.example.api.shared.interfaces.IQueryBuilder;

public class SearchFilmsQueryBuilder implements IQueryBuilder<Film> {
    private SearchFilmsRequest request;

    private Film probe = new Film();

    private ExampleMatcher matcher = ExampleMatcher.matching();

    public SearchFilmsQueryBuilder(SearchFilmsRequest request) {
        this.request = request;

        this.setCountry();
    }

    private void setCountry() {
        if (this.request.getCountry() != null) {
            this.matcher = this.matcher.withMatcher("country",
                    ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
            this.probe.setCountry(this.request.getCountry());
        }
    }

    public Example<Film> getExample() {
        return Example.of(this.probe, this.matcher);
    }
}
