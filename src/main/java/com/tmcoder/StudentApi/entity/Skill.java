package com.tmcoder.StudentApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "s")
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skill;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Student s;

    public Skill(int id, String skill, Student s) {
        this.id = id;
        this.skill = skill;
        this.s = s;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Skill that)) return false;

        return skill != null && skill.equalsIgnoreCase(that.skill);  // compare only by skill name
    }

    @Override
    public int hashCode() {
        return skill != null ? skill.toLowerCase().hashCode() : 0;
    }

}
