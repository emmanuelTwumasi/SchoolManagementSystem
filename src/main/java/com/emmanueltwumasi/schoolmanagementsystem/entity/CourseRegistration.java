package com.emmanueltwumasi.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "course_registration")
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_registration_id", nullable = false)
    private Long courseRegistrationId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @Column(name = "registration_date")
    LocalDateTime registrationDate;

    @Column(name = "grade")
    int grade;

}