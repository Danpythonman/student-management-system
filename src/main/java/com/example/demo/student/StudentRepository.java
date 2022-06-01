package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);

    @Query(
            value = "SELECT * FROM student WHERE TIMESTAMPDIFF(YEAR, dob, NOW()) > 18",
            nativeQuery = true
    )
    Optional<List<Student>> findStudentsOver18YearsOld();

}
