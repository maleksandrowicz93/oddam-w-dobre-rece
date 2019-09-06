package com.github.maleksandrowicz93.oddamwdobrerece.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    @Email
    private String username;
    private String password;
    private String confirmedPassword;
    private String firstName;
    private String lastName;
    private String role;

}
