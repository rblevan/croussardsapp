package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.User;
import fr.univ_poitiers.croussards.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return user;
    }
}
