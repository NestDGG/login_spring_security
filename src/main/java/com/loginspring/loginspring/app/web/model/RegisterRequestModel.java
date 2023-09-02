package com.loginspring.loginspring.app.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
}
