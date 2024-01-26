package com.emmanueltwumasi.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Column(name="name")
    private String name;
    
}
