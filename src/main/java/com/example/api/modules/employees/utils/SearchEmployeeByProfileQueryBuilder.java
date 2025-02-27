package com.example.api.modules.employees.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.employees.entities.Employee;
import com.example.api.shared.interfaces.IQueryBuilder;

public class SearchEmployeeByProfileQueryBuilder implements IQueryBuilder<Employee> {
    private Employee probe = new Employee();

    private ExampleMatcher matcher = ExampleMatcher.matching();

    public SearchEmployeeByProfileQueryBuilder(Profile profile) {
        this.setProfile(profile);
    }

    private void setProfile(Profile profile) {
        if (profile != null) {
            this.matcher = this.matcher.withMatcher("profile", ExampleMatcher.GenericPropertyMatchers.exact());
            this.probe.setProfile(profile);
        }
    }

    public Example<Employee> getExample() {
        return Example.of(this.probe, this.matcher);
    }
}
