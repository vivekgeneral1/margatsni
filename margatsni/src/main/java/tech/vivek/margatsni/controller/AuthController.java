package tech.vivek.margatsni.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.vivek.margatsni.exchange.request.LoginRequest;
import tech.vivek.margatsni.exchange.request.SignupRequest;
import tech.vivek.margatsni.exchange.response.AuthResponse;
import tech.vivek.margatsni.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
//        var res = authService.login(loginRequest);
//        return ResponseEntity.ok(res);
//    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest signupRequest) {
        var res = authService.signup(signupRequest);
        return ResponseEntity.ok(res);
    }

}
