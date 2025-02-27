package com.example.api.modules.auth.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.auth.enums.Role;
import com.example.api.modules.auth.repositories.ProfilesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfilesService {
    private final ProfilesRepository profilesRepository;

    public Profile save(Profile profile) {
        return this.profilesRepository.save(profile);
    }

    public Profile create(Profile profile) {
        if (this.profilesRepository.existsByEmail(profile.getEmail())) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }

        return this.save(profile);
    }

    public Profile findByEmail(String email) {
        return this.profilesRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::findByEmail;
    }

    public Profile findCurrentProfile() {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.findByEmail(email);
    }

    @Deprecated
    public void getAdmin() {
        var profile = this.findCurrentProfile();
        profile.setRole(Role.ROLE_EMPLOYEE);
        this.save(profile);
    }
}
