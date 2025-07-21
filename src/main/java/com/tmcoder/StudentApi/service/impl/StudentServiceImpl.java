package com.tmcoder.StudentApi.service.impl;

import com.tmcoder.StudentApi.dao.SkillRepo;
import com.tmcoder.StudentApi.dao.StudentRepo;
import com.tmcoder.StudentApi.entity.Student;
import com.tmcoder.StudentApi.entity.StudentSkill;
import com.tmcoder.StudentApi.exception.StudentNotFound;
import com.tmcoder.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    SkillRepo skillRepo;

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudent(int studentId) {
        return studentRepo.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student ID: " + studentId + " not found"));
    }

    @Override
    public void addStudent(Student student) {
        if (student.getId() != 0 && studentRepo.existsById(student.getId())) {
            throw new StudentNotFound("Student ID: " + student.getId() + " is already present");
        }
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepo.deleteById(getStudent(studentId).getId());
    }

    @Override
    public Student addSkill(int studentId, StudentSkill studentSkill) {
        studentSkill.setS(getStudent(studentId));
        skillRepo.save(studentSkill);
        return studentSkill.getS();
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepo.findStudentByName(name);
    }
}
