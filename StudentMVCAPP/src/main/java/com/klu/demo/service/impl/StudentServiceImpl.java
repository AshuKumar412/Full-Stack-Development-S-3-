package com.klu.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.klu.demo.model.Student;
import com.klu.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    // Welcome
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student MVC CRUD Application";
    }

    // Create
    @Override
    public Student createStudent(Student student) {
        studentList.add(student);
        return student;
    }

    // Read - Get by Id
    @Override
    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Read - Get All
    @Override
    public List<Student> getAll() {
        return studentList;
    }

    // Update
    @Override
    public Student updateStudent(int id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                student.setId(id);
                studentList.set(i, student);
                return student;
            }
        }
        return null;
    }

    // Delete
    @Override
    public String deleteStudent(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                return "Student record deleted Successfully";
            }
        }
        return "No Student record found";
    }

    // Search
    @Override
    public List<Student> searchStudent(String name, String course) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name) && 
                s.getCourse().equalsIgnoreCase(course)) {
                result.add(s);
            }
        }
        return result;
    }
}
