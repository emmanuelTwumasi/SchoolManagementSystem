package com.emmanueltwumasi.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="course")
public class Course extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "course",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    Set<CourseRegistration> registrations = new HashSet<>();

}
