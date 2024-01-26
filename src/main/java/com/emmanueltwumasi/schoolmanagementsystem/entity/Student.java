package com.emmanueltwumasi.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId", nullable = false)
    private Long studentId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="role")
    private Role role;

    @OneToMany
    private Set<Course> courseList;

}
