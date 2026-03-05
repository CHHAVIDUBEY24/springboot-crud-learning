package com.example.practice.service;

import com.example.practice.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> students=new ArrayList<>();

    //create
    public Student createStudent(Student s)
    {
        students.add(s);
        return s;
    }
    //read
    public List<Student> getAllStudent()
    {
        return students;
    }

    //read-> id
    public Student getStudentById(int id)
    {
        for(Student s:students)
        {
            if(s.getId()==id)
            {
                return s;
            }
        }
        return null;
    }

    //update
    public Student updateStudent(int id,Student us)
    {
        for(Student s:students)
        {
            if(s.getId()==id)
            {
                s.setName(us.getName());
                s.setEmail(us.getEmail());
                return s;
            }
        }
        return null;
    }
    public void deleteStudent(int id)
    {
        students.removeIf(s->s.getId()==id);
    }
}
