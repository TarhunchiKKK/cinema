package com.example.api.modules.halls.repositories;

import com.example.api.modules.halls.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallsRepository extends JpaRepository<Hall, Long> {

}
