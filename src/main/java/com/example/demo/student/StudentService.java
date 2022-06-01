package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Optional<Student> studentOptional = this.studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("Id invalid");
        }

        Student student = studentOptional.get();

        if (name != null && name.length() > 0
                && !student.getName().equals(name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0
                && !student.getEmail().equals(email)) {
            student.setEmail(email);
        }
    }

    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);
    }

}
