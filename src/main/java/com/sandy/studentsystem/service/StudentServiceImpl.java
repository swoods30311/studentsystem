package com.sandy.studentsystem.service;

import com.sandy.studentsystem.model.Student;
import com.sandy.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired(required = true)
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public String updateStudentDetails(Integer id, Student student) {
        if(studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
            return "Student details with ID "+ id +" updated successfully";
        }
        return "No record found for student with ID "+id;
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }
}
