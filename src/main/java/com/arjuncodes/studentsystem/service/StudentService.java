package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Student;

import java.util.List;
//Only need a service if we're introducing new logic
public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}