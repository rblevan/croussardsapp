package fr.univpoitiers.croussardsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "students")
@Data
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_student;

    private String last_name;

    private String first_name;

    private String mail;

    private String pwd_hash;

    private Date date_birth;

    private String username;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Review> reviews = new ArrayList<>();

    // DTO : UserDetails

    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.pwd_hash;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.num_student);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}