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

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return this.studentRepository.findById(id).get();
    }

    public void saveStudent(Student student) {
        Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

        this.studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);
    }

}
