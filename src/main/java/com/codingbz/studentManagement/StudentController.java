package com.codingbz.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    // get information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("admnNo") int admnNo){
        return db.get(admnNo);
    }

    //adding the information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return  "Student added successfully";
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        if(!db.containsKey(id)){
            return "Invalid Id";
        }

        db.remove(id);
        return "Student Removed successfully";
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id ,@RequestParam("age") int age){
        if(!db.containsKey(id)){
            return "Invalid Id";
        }
        Student student = db.get(id);
        student.setAge(age);
        db.put(id,student);

        // db.get(id).setAge(20);

        return "Student update successfully";
    }
}
