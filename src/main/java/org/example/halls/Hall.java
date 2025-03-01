package org.example.halls;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;

public class Hall implements IHaveId, IPrintable {
    private Long id;

    private String type;

    private Integer seatsCount;

    public Hall(String type, Integer seatsCount) {
        this.type = type;
        this.seatsCount = seatsCount;
    }

    public Hall(Long id, String type, Integer seatsCount) {
        this.id = id;
        this.type = type;
        this.seatsCount = seatsCount;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeatsCount() {
        return this.seatsCount;
    }

    public void setSeatsCount(Integer seatsCount) {
        this.seatsCount = seatsCount;
    }

    public void print() {
        System.out.printf("%4d %10s %d\n", this.id, this.type, this.seatsCount);
    }
}
