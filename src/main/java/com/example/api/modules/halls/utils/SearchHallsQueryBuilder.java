package com.example.api.modules.halls.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.example.api.modules.halls.dtos.SearchHallsRequest;
import com.example.api.modules.halls.entities.Hall;
import com.example.api.shared.interfaces.IQueryBuilder;

public class SearchHallsQueryBuilder implements IQueryBuilder<Hall> {
    private SearchHallsRequest request;

    private Hall probe = new Hall();

    private ExampleMatcher matcher = ExampleMatcher.matching();

    public SearchHallsQueryBuilder(SearchHallsRequest request) {
        this.request = request;

        this.setType();
    }

    private void setType() {
        if (this.request.getType() != null) {
            this.matcher = this.matcher.withMatcher("type",
                    ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
            this.probe.setType(this.request.getType());
        }
    }

    public Example<Hall> getExample() {
        return Example.of(this.probe, this.matcher);
    }
}
