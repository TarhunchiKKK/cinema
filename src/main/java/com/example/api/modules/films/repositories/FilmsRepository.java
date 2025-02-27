package com.example.api.modules.films.repositories;

import com.example.api.modules.films.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Film, Long> {

}
