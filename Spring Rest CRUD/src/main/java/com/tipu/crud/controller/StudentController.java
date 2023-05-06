package com.tipu.crud.controller;

import com.tipu.crud.model.Student;
import com.tipu.crud.repository.StudentRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepsitory studentRepsitory;

    @PostMapping("/student")
        //why return type is student??
    Student addStudent(@RequestBody Student newStudent) {
        return studentRepsitory.save(newStudent);
    }

    @GetMapping("/student/{id}")
    Optional<Student> viewStudent(@PathVariable int id) {
        return studentRepsitory.findById(id);
    }

    @PutMapping("/user/{id}")
    Optional<Student> updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
        return studentRepsitory.findById(id).map(student -> {
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            return studentRepsitory.save(student);

        });
    }

    @DeleteMapping("student/{id}")
    void deleteStudent(@PathVariable int id){
        studentRepsitory.deleteById(id);
    }
}
