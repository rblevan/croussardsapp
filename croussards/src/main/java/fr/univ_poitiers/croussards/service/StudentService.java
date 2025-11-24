package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

<<<<<<< HEAD
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Optional<Student> getStudent(final Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Review> getReview(final Long id) {
        return reviewRepository.findById(id);
    }

    public Optional<Restaurant> getRestaurant(final Long id) {
        return restaurantRepository.findById(id);
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Iterable<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }


}
=======
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
>>>>>>> f3bc149 (les mappings marchent maintenant)
