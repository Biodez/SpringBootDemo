package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> findStudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (findStudentByEmail.isPresent()){
            throw new IllegalStateException("The email exist");
        }
        studentRepository.save(student);
    }
}
