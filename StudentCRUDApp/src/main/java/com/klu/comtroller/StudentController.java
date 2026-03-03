package com.klu.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;
import com.klu.exception.StudentNotFoundException;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // Welcome
    @GetMapping("/greet")
    public String getWelcomeMessage() {
        return service.getWelcomeMessage();
    }

    // Create
    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // Get All
    @GetMapping("/getall")
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // Get By ID
    @GetMapping("/getid/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = service.getStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }

    // Update
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {

        Student updated = service.updateStudent(id, student);

        if (updated == null) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return updated;
    }

    // Delete
    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable int id) {

        Student student = service.getStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return service.deleteStudent(id);
    }

    // ✅ Search by ID OR Name
    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String value) {
        return service.searchStudent(value);
    }
}