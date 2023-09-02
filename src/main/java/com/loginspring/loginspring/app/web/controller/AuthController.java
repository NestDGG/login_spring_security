package com.loginspring.loginspring.app.web.controller;


import com.loginspring.loginspring.app.constants.Constants;
import com.loginspring.loginspring.app.service.AuthService;
import com.loginspring.loginspring.app.web.model.AuthResponseModel;
import com.loginspring.loginspring.app.web.model.LoginRequestModel;
import com.loginspring.loginspring.app.web.model.RegisterRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION + "/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody LoginRequestModel loginRequestModel) {
        return ResponseEntity.ok(authService.login(loginRequestModel));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseModel> register(@RequestBody RegisterRequestModel registerRequestModel) {
        return ResponseEntity.ok(authService.register(registerRequestModel));    }
}
