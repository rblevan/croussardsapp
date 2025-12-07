package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import fr.univ_poitiers.croussards.model.Review;


@Entity
@Table(name = "students")
@Data
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_student;
    private Long id;

    private String name;

    private String first_name;
    private String firstName;

    private String mail;
    private String email;

    private String pwd_hash;
    private String username;

    private String date_birth; // Ideally LocalDate
    private String password;

    private String username;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    // DTO : UserDetails
    //--- UserDetails Implementation ---//

    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
        // Return an empty list instead of null to avoid NullPointerExceptions
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.pwd_hash;
        return this.password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.num_student);
        // The username field should be used for authentication, not the ID.
        return this.username;
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