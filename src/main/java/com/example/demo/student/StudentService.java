package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    // Is this a real bean moment?
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

    public ResponseEntity<String> getStudentEmailById(Long id) {
        Optional<Student> studentOptional = this.studentRepository.findById(id);
        String responseString;

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status;

        if (studentOptional.isEmpty()) {
            responseString = "student with id " + id + " not found";
            headers.add("found", "no");
            status = HttpStatus.NOT_FOUND;
        } else {
            headers.add("found", "yes");
            status = HttpStatus.OK;
            responseString = studentOptional.get().getEmail();
        }

        return new ResponseEntity<String>(
                responseString,
                headers,
                status
        );
    }

    public ResponseEntity<LocalDate> getStudentDobFromId(Long id) {
        Optional<Student> studentOptional = this.studentRepository.findById(id);

        return studentOptional.isPresent()
            ? ResponseEntity.status(200)
                .header("found", "yes")
                .body(studentOptional.get().getDob())
            : ResponseEntity.status(404)
                .header("found", "no")
                .body(null);
    }

    public List<Student> getStudentsAbove18YearsOld() {
        return this.studentRepository.findStudentsOver18YearsOld().get();
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
