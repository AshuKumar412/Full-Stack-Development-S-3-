package com.klu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.demo.model.Student;
import com.klu.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // Welcome
    @GetMapping("/greet")
    public String getWelcomeMessage() {
        return service.getWelcomeMessage();
    }

    // Create
    @PostMapping("/student/add")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // Get All
    @GetMapping("/student/getall")
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // Get by ID
    @GetMapping("/student/getid/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Update
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete
    @DeleteMapping("/student/del/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

    // Search
    @GetMapping("/student/search")
    public List<Student> searchStudent(@RequestParam String name,
                                       @RequestParam String course) {
        return service.searchStudent(name, course);
    }
}
