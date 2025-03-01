package org.example.employees;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;

public class Employee implements IHaveId, IPrintable {
    private Long id;

    private String fio;

    private String post;

    private Float experience;

    public Employee(String fio, String post, Float experience) {
        this.fio = fio;
        this.post = post;
        this.experience = experience;
    }

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

    public void print() {
        System.out.printf("%4d %30s %10s %f\n", this.id, this.fio, this.post, this.experience);
    }
}
