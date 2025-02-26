package org.example.employees;

public class Employee {
    private Long id;

    private String fio;

    private String post;

    private Float experience;

    public Employee(Long id, String fio, String post, Float experience) {
        this.id = id;
        this.fio = fio;
        this.post = post;
        this.experience = experience;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return this.fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Float getExperience() {
        return this.experience;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }
}
