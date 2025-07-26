package com.tmcoder.StudentApi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dob;
    @JsonManagedReference
    @OneToMany(mappedBy = "s", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private List<Skill> skills;

    public Student(int id, String name, String dob, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.skills = skills;
    }
}
