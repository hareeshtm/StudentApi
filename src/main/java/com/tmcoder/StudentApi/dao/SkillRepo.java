package com.tmcoder.StudentApi.dao;

import com.tmcoder.StudentApi.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {
}
