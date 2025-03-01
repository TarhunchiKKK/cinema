package org.example.visitors;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;

public class Visitor implements IHaveId, IPrintable {
    private Long id;

    private String fio;

    private Integer age;

    public Visitor(String fio, Integer age) {
        this.fio = fio;
        this.age = age;
    }

    public Visitor(Long id, String fio, Integer age) {
        this.id = id;
        this.fio = fio;
        this.age = age;
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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void print() {
        System.out.printf("%4d %30s %d\n", this.id, this.fio, this.age);
    }
}
