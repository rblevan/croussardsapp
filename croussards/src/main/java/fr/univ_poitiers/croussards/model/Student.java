package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

// Supposant que la classe Review existe aussi dans ce package ou est importée
// import fr.univ_poitiers.croussards.model.Review;

@Data
@Entity
public class Student implements UserDetails {
    @OneToMany(mappedBy = "student")
    private List<Review> reviews = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_student")
    private Long numStudent;

    private String name;

    @Column(name = "first_name")
    private String firstName;

    private String mail;

    @Column(name = "pwd_hash")
    private String pwdHash;

    @Column(name = "date_birth")
    private String dateBirth;

    private String username;

    // DTO : UserDetails

    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.pwdHash;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.numStudent);
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