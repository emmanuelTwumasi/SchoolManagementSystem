package com.emmanueltwumasi.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    @Column(name="username")
    private String username;

}
