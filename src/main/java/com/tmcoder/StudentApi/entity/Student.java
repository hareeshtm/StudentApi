package com.tmcoder.StudentApi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

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
    @JsonFormat(pattern = "dd-MM-yyy")
    private LocalDate dob;
    @JsonManagedReference
    @OneToMany(mappedBy = "s", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private Set<Skill> skills;

    public Student(int id, String name, LocalDate dob, Set<Skill> skills) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.skills = skills;
    }
}
