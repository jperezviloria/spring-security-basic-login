package com.login.v1.controller;

import com.login.v1.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> studentList = Arrays.asList(
            new Student("1","James Bond"),
            new Student("2", "Maria Jones"),
            new Student("3", "Ana Smith")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") String studentId){
        return studentList.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student" + studentId + "does not exist"));
    }

}
