package com.example.api.modules.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.auth.dtos.EmployeeSignUpRequest;
import com.example.api.modules.auth.dtos.SignInRequest;
import com.example.api.modules.auth.dtos.SignInResponse;
import com.example.api.modules.auth.dtos.SignUpResponse;
import com.example.api.modules.auth.dtos.VisitorSignUpRequest;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.auth.services.AuthService;
import com.example.api.shared.utils.ErrorsCollector;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up/visitor")
    public ResponseEntity<?> signUpVisitor(@RequestBody @Valid VisitorSignUpRequest request,
            BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<SignUpResponse>(this.authService.signUpVisitor(request), HttpStatus.CREATED);
    }

    @PostMapping("/sign-up/employee")
    public ResponseEntity<?> signUpEmployee(@RequestBody @Valid EmployeeSignUpRequest request,
            BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<SignUpResponse>(this.authService.signUpEmployee(request), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInRequest request, BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<SignInResponse>(this.authService.signIn(request), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<Profile> getProfile() {
        return new ResponseEntity<Profile>(this.authService.getProfile(), HttpStatus.OK);
    }
}
