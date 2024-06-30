package pro.sky.api_swaggerui_postman.service;

import org.springframework.stereotype.Service;
import pro.sky.api_swaggerui_postman.faculty.Student;
import pro.sky.api_swaggerui_postman.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public Optional<Student> deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
        }
        return student;
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
