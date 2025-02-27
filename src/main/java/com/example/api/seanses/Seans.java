package com.example.api.seanses;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.api.employees.Employee;
import com.example.api.films.Film;
import com.example.api.halls.Hall;
import com.example.api.visitors.Visitor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seanses")
public class Seans {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Float price;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "seanses_visitors", joinColumns = @JoinColumn(name = "seans_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "visitor_id", referencedColumnName = "id"))
    private Set<Visitor> visitors = new HashSet<Visitor>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "seanses_employees", joinColumns = @JoinColumn(name = "seans_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private Set<Employee> employees = new HashSet<Employee>();

    public Seans(Date date, Float price, Integer duration) {
        this.date = date;
        this.price = price;
        this.duration = duration;
    }
}
