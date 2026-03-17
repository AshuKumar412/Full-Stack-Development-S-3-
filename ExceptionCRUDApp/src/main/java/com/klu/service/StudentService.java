package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repository;

    // CREATE
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // READ ALL (Pagination)
    public Page<Student> getAllStudents(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }

    // READ BY COURSE
    public Page<Student> getStudentsByCourse(String course, int page, int size) {

        Page<Student> students =
                repository.findByCourse(course, PageRequest.of(page, size));

        if (students.isEmpty()) {
            throw new StudentNotFoundException(
                    "No students found for course: " + course);
        }
        return students;
    }

    // UPDATE
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existing = getStudentById(id);

        existing.setName(updatedStudent.getName());
        existing.setCourse(updatedStudent.getCourse());
        existing.setAge(updatedStudent.getAge());

        return repository.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);
        repository.delete(student);
    }
}