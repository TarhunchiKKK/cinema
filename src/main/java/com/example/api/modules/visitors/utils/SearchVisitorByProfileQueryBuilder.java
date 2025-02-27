package com.example.api.modules.visitors.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.visitors.entities.Visitor;
import com.example.api.shared.interfaces.IQueryBuilder;

public class SearchVisitorByProfileQueryBuilder implements IQueryBuilder<Visitor> {
    private Visitor probe = new Visitor();

    private ExampleMatcher matcher = ExampleMatcher.matching();

    public SearchVisitorByProfileQueryBuilder(Profile profile) {
        this.setProfile(profile);
    }

    private void setProfile(Profile profile) {
        if (profile != null) {
            this.matcher = this.matcher.withMatcher("profile", ExampleMatcher.GenericPropertyMatchers.exact());
            this.probe.setProfile(profile);
        }
    }

    public Example<Visitor> getExample() {
        return Example.of(this.probe, this.matcher);
    }
}
