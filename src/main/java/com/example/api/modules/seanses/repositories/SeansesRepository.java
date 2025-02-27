package com.example.api.modules.seanses.repositories;

import com.example.api.modules.seanses.entities.Seans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeansesRepository extends JpaRepository<Seans, Long> {

}
