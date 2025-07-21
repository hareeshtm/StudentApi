package com.tmcoder.StudentApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
