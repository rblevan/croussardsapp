package fr.univ_poitiers.croussards.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private Long numStudent;
    private String password;
}


