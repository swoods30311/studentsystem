package com.sandy.studentsystem.service;

import com.sandy.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();

    public void deleteStudent(Integer id);

    public String updateStudentDetails(Integer id, Student student);

    public Optional<Student> getStudentById(Integer id);
}
