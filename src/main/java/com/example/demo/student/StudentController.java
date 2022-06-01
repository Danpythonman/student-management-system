package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseBody
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @ResponseBody
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return this.studentService.getStudentById(id);
    }

    @ResponseBody
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        this.studentService.saveStudent(student);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        this.studentService.updateStudent(id, name, email);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        this.studentService.deleteStudentById(id);
    }

    @ResponseBody
    @GetMapping("/student/{id}/email")
    public ResponseEntity<String> getStudentEmail(@PathVariable("id") Long id) {
        return this.studentService.getStudentEmailById(id);
    }

    @ResponseBody
    @GetMapping("/student/{id}/dob")
    public ResponseEntity<LocalDate> getStudentDob(@PathVariable("id") Long id) {
        return this.studentService.getStudentDobFromId(id);
    }

    @GetMapping("/student/page")
    public String getStudentPage2(Model model) {
        model.addAttribute("attribute", "Text from controller");
        return "student.html";
    }

}
