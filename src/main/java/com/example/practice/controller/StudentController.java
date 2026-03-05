package com.example.practice.controller;

import com.example.practice.entity.Student;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id)
    {
       return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
       studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student updatedStudent)
    {
        return studentService.updateStudent(id,updatedStudent);
    }
}
