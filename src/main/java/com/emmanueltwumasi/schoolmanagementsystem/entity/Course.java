package com.emmanueltwumasi.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "course")
public class Course extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="code")
    private String code;

    @OneToMany(mappedBy = "course",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    List<CourseRegistration> registrations = new ArrayList<>();

    @CreatedBy
    private String createdBy;


    @LastModifiedBy
    private String lastModifiedBy;

}
