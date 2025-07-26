package com.tmcoder.StudentApi.controller;

import com.tmcoder.StudentApi.entity.Student;
import com.tmcoder.StudentApi.entity.Skill;
import com.tmcoder.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping(method= RequestMethod.GET , value ="/students" )
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return service.getStudent(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        service.addStudent(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        service.deleteStudent(studentId);
        return "Deleted Student :"+ studentId;
    }

    public Student addSkill(@PathVariable int studentId, @RequestBody Skill studentSkill) {
        return service.addSkill(studentId, studentSkill);
    }

    @PostMapping("/students/{name}")
    public List<Student> findStudentsByName(@PathVariable String name) {
        return service.findStudentsByName(name);
    }
}
