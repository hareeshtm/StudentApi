package com.tmcoder.StudentApi.service;

import com.tmcoder.StudentApi.entity.Student;
import com.tmcoder.StudentApi.entity.StudentSkill;

import java.util.List;

public interface StudentService {
    public List<Student> findAllStudents();

    public Student getStudent(int studentId);

    public void addStudent(Student student);

    public void deleteStudent(int studentId);

    public Student addSkill(int studentId , StudentSkill studentSkill);

    public List<Student> findStudentsByName(String name);

}
