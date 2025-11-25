package fr.univ_poitiers.croussards.service;

// import from our package

import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Long numStudent = Long.parseLong(username);
            return studentRepository.findById(numStudent)

                    // todo : exception request
                    .orElseThrow(() -> new UsernameNotFoundException("Aucun étudiant trouvé avec le numéro : " + username));
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Format du numéro étudiant invalide : " + username);
        }
    }
}
