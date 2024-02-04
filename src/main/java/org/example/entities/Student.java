package org.example.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import org.example.entities.keys.StudentKey;

import java.util.Objects;

@Entity
public class Student {

    @EmbeddedId
    private StudentKey id;

    private String name;

    public StudentKey getId() {
        return id;
    }

    public void setId(StudentKey id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
