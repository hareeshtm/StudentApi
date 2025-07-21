package com.tmcoder.StudentApi.dao;

import com.tmcoder.StudentApi.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // Custom query method to find students by name
    @Query("select s from Student s where s.name=?1")
    List<Student> findStudentByName(String name);
}
