package org.example.halls;

public class Hall {
    private Long id;

    private String type;

    private Integer seatsCount;

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
}
