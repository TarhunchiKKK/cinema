package com.example.api.films;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Film, Long> {

}
