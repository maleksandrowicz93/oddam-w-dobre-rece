package com.github.maleksandrowicz93.oddamwdobrerece.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isAdmin;

}