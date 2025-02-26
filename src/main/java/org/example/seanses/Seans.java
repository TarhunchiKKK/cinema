package org.example.seanses;

import java.util.Date;

public class Seans {
    private Long id;

    private Date date;

    private Float price;

    private Integer duration;

    public Seans(Long id, Date date, Float price, Integer duration) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.duration = duration;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return new java.sql.Date(
                this.date.getDate(),
                this.date.getMonth(),
                this.date.getYear() + 1900);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
