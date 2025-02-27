package com.example.api.modules.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.api.modules.auth.dtos.EmployeeSignUpRequest;
import com.example.api.modules.auth.dtos.SignInRequest;
import com.example.api.modules.auth.dtos.SignInResponse;
import com.example.api.modules.auth.dtos.SignUpRequest;
import com.example.api.modules.auth.dtos.SignUpResponse;
import com.example.api.modules.auth.dtos.VisitorSignUpRequest;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.employees.EmployeesService;
import com.example.api.modules.employees.dtos.CreateEmployeeRequest;
import com.example.api.modules.visitors.VisitorsService;
import com.example.api.modules.visitors.dtos.CreateVisitorRequest;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final VisitorsService visitorsService;

    private final EmployeesService employeesService;

    private final ProfilesService profilesService;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private SignUpResponse signUp(SignUpRequest request) {
        var profile = Profile.builder()
                .email(request.getEmail())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        Profile createdProfile = this.profilesService.create(profile);
        var jwt = this.jwtService.generateToken(createdProfile);
        return new SignUpResponse(createdProfile, jwt);
    }

    public SignUpResponse signUpVisitor(VisitorSignUpRequest request) {
        SignUpRequest signUpRequest = new SignUpRequest(request.getEmail(), request.getPassword(), request.getRole());
        SignUpResponse signUpResponse = this.signUp(signUpRequest);

        CreateVisitorRequest createVisitorRequest = new CreateVisitorRequest(request.getFio(), request.getAge(),
                signUpResponse.getProfile());
        this.visitorsService.create(createVisitorRequest);

        return signUpResponse;
    }

    public SignUpResponse signUpEmployee(EmployeeSignUpRequest request) {
        SignUpRequest signUpRequest = new SignUpRequest(request.getEmail(), request.getPassword(), request.getRole());
        SignUpResponse signUpResponse = this.signUp(signUpRequest);

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest(request.getFio(), request.getPost(),
                request.getExperience(), signUpResponse.getProfile());
        this.employeesService.create(createEmployeeRequest);

        return signUpResponse;
    }

    public SignInResponse signIn(SignInRequest request) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));

        var userDetails = this.profilesService
                .userDetailsService()
                .loadUserByUsername(request.getEmail());

        Profile storedUser = this.profilesService.findByEmail(userDetails.getUsername());

        var jwt = this.jwtService.generateToken(userDetails);
        return new SignInResponse(storedUser, jwt);
    }

    public Profile getProfile() {
        return this.profilesService.findCurrentProfile();
    }
}