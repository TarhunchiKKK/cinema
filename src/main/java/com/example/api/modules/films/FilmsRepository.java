package com.example.api.modules.films;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Film, Long> {

}
