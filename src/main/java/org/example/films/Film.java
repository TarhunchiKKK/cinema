package org.example.films;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;

public class Film implements IHaveId, IPrintable {
    private Long id;

    private String title;

    private Integer year;

    private String country;

    public Film(String title, Integer year, String country) {
        this.title = title;
        this.year = year;
        this.country = country;
    }

    public Film(Long id, String title, Integer year, String country) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void print() {
        System.out.printf("%4d %15s %4d %s\n", this.id, this.title, this.year, this.country);

    }
}
