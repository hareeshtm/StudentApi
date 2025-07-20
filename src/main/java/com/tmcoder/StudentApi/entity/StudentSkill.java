package com.tmcoder.StudentApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "s")
@Entity
@Table(name = "skill")
public class StudentSkill {
    private int id;
    private String skill;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Student s;

    public StudentSkill(int id, String skill, Student s) {
        this.id = id;
        this.skill = skill;
        this.s = s;
    }
}
