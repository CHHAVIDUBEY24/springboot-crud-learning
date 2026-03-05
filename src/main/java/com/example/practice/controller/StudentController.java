package com.example.practice.controller;

import com.example.practice.entity.Student;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List <Student> students=studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student savedStudent= studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        //Alternate
        //return ResponseEntity.status(201).body(savedStudent);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id)
    {
        Student student=studentService.getStudentById(id);
        if(student==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id)
    {
        Student student=studentService.getStudentById(id);
        if(student==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student)
    {
        Student updatedStudent=studentService.updateStudent(id,student);
        if(updatedStudent==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }
}
