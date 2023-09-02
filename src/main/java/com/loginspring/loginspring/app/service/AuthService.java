package com.loginspring.loginspring.app.service;


import com.loginspring.loginspring.app.domain.entity.User;
import com.loginspring.loginspring.app.util.Role;
import com.loginspring.loginspring.app.web.model.AuthResponseModel;
import com.loginspring.loginspring.app.web.model.LoginRequestModel;
import com.loginspring.loginspring.app.web.model.RegisterRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponseModel login(LoginRequestModel loginRequestModel) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestModel.getUsername(), loginRequestModel.getPassword()));
        UserDetails user = usersService.findByusername(loginRequestModel.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponseModel.builder()
                .token(token)
                .build();
    }

    public AuthResponseModel register(RegisterRequestModel registerRequestModel) {
        User user = User.builder()
                .username(registerRequestModel.getUsername())
                .password(passwordEncoder.encode(registerRequestModel.getPassword()))
                .fistName(registerRequestModel.getFirstName())
                .lastName(registerRequestModel.getLastName())
                .email(registerRequestModel.getEmail())
                .role(Role.USER)
                .build();

        usersService.saveUser(user);


        return AuthResponseModel.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
