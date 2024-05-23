package com.example.prak10;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversityController {

    private List<Student> students = new ArrayList<>();
    private List<University> universities = new ArrayList<>();

    @PostMapping("/student")
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        students.add(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @DeleteMapping("/student/{index}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/university")
    public ResponseEntity<Void> createUniversity(@RequestBody University university) {
        universities.add(university);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/universities")
    public List<University> getAllUniversities() {
        return universities;
    }

    @DeleteMapping("/university/{index}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable int index) {
        if (index >= 0 && index < universities.size()) {
            universities.remove(index);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}