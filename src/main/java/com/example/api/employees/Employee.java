package com.example.api.employees;

import java.util.HashSet;
import java.util.Set;

import com.example.api.seanses.Seans;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "post")
    private String post;

    @Column(name = "experience")
    private Float experience;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "seanses_employees", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "seans_id", referencedColumnName = "id"))
    private Set<Seans> seanses = new HashSet<Seans>();

    public Employee(String fio, String post, Float experience) {
        this.fio = fio;
        this.post = post;
        this.experience = experience;
    }
}
