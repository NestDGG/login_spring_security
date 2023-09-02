package com.loginspring.loginspring.app.web.controller;


import com.loginspring.loginspring.app.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION + "/users")
@RequiredArgsConstructor
public class UsersController {

    @PostMapping()
    public String createUser() {
        return "User created";
    }

}
