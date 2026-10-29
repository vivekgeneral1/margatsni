package tech.vivek.margatsni.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.vivek.margatsni.exchange.request.LoginRequest;
import tech.vivek.margatsni.exchange.request.SignupRequest;
import tech.vivek.margatsni.exchange.response.AuthResponse;
import tech.vivek.margatsni.model.AppUser;
import tech.vivek.margatsni.repository.AppUserRepository;

@Service
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            AppUserRepository appUserRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.appUserRepository = appUserRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

//    public AuthResponse login(LoginRequest loginRequest) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.username(),
//                        loginRequest.password()
//                )
//        );
//        return new AuthResponse( "success", "token");
//    }

    public AuthResponse signup(SignupRequest signupRequest) {

        if(appUserRepository.existsByUsername(signupRequest.username())){
            throw new RuntimeException("Username already exists");
        }
        if(appUserRepository.existsByEmail(signupRequest.email())){
            throw new RuntimeException("Email already exists");
        }
        AppUser appUser = new AppUser(
                signupRequest.name(),
                signupRequest.username(),
                signupRequest.email(),
                passwordEncoder.encode(signupRequest.password()),
                signupRequest.profilePic(),
                signupRequest.bio()
        );

        appUserRepository.save(appUser);
        return new AuthResponse("success", "token");
    }
}
