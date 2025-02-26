package org.example.films;

public class Film {
    private Long id;

    private String title;

    private Integer year;

    private String country;

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
}
