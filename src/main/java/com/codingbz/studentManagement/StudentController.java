package com.codingbz.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    // get information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
        Student response =  studentService.GetStudent(admnNo);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.AddStudent(student);
        return  new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.DeleteStudent(id);
        if(response.equals("Invalid Id")){
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id ,@RequestParam("age") int age){
        String response =  studentService.UpdateStudent(id, age);
        if(response.equals("Invalid Id")){
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
