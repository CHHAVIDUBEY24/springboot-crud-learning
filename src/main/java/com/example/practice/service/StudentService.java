package com.example.practice.service;

import com.example.practice.entity.Student;
import com.example.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //create
    public Student createStudent(Student s)
    {
        studentRepository.save(s);
        return s;
    }
    //read
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll()  ;
    }

    //read-> id
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    //update
    public Student updateStudent(int id,Student us)
    {
        Student student=studentRepository.findById(id).orElse(null);
        if(student!=null)
        {
            student.setEmail(us.getEmail());
            student.setName(us.getName());
            return student;
        }
        return null;
    }
    public void deleteStudent(int id)
    {
        studentRepository.deleteById(id);
    }
}
