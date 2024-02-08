package org.example.dto;

import org.example.entities.Student;

public record CountedEnrollmentStudent (
        Student s,
        Long count
) {
}
