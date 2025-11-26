package fr.univ_poitiers.croussards.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String first_name;
    private String mail;
    private String password;
}
