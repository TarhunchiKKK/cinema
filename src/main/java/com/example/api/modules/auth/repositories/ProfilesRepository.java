package com.example.api.modules.auth.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.modules.auth.entties.Profile;

public interface ProfilesRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);

    boolean existsByEmail(String email);
}
