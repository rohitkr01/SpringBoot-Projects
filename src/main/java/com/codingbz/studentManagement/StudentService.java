package com.codingbz.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String AddStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public String DeleteStudent(int id){
        return studentRepository.deleteStudent(id);
    }

    public String UpdateStudent(int id, int age){
        return studentRepository.updateStudent(id, age);
    }

    public Student GetStudent(int id){
        return studentRepository.getStudent(id);
    }
}
