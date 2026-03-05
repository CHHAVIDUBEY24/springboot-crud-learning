package com.example.practice.controller;

import com.example.practice.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    List<Student> students=new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudent()
    {
        return students;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student)
    {
        students.add(student);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id)
    {
        for(Student s: students)
        {
            if(s.getId()==id)
            {
                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id)
    {
        Iterator<Student> iterator=students.iterator();

        while(iterator.hasNext())
        {
            Student s=iterator.next();
            if(s.getId()==id)
            {
                students.remove(s);
                return "Student deleted";
            }
        }
        return "Student not found";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student updatedStudent)
    {
        for(Student s:students)
        {
            if(s.getId()==id)
            {
                s.setEmail(updatedStudent.getEmail());
                s.setName(updatedStudent.getName());
                return s;
            }
        }
        return null;
    }
}
