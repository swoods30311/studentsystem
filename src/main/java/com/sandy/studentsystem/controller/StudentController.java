package com.sandy.studentsystem.controller;

import com.sandy.studentsystem.model.Student;
import com.sandy.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        Student studentResponse = studentService.saveStudent(student);
        return "New student is added with Id "+studentResponse.getId();
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        Optional<Student> studentResponse = studentService.getStudentById(id);
        if(studentResponse.isPresent())
            return studentResponse.get();
        else
            return null;
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "Student details with ID "+id+" is deleted";
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestBody Student student) {
        return studentService.updateStudentDetails(id, student);
    }

}

