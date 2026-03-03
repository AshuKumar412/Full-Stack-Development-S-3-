package com.klu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;
import com.klu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    // Welcome
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student MVC CRUD Application";
    }

    // Create
    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // Read - Get by Id
    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    // Read - Get All
    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    // Update
    @Override
    public Student updateStudent(int id, Student student) {
        Student existing = studentRepo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setCourse(student.getCourse());
            return studentRepo.save(existing);
        }

        return null;
    }

    // Delete
    @Override
    public String deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Student record deleted successfully";
        }
        return "Student not found";
    }

    // ✅ Search by ID OR Name only
    @Override
    public List<Student> searchStudent(String value) {

        // Try searching by ID
        try {
            int id = Integer.parseInt(value);
            Student student = studentRepo.findById(id).orElse(null);

            if (student != null) {
                return List.of(student);
            }

        } catch (NumberFormatException e) {
            // Not a number → continue to search by name
        }

        // Search by Name (partial match, ignore case)
        return studentRepo.findByNameContainingIgnoreCase(value);
    }
}