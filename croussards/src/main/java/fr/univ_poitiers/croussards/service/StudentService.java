package fr.univ_poitiers.croussards.service;

// Import corrigé

import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    // public Student registerStudent(...)
}