package com.emmanueltwumasi.schoolmanagementsystem.service.responsedto;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class StudentData {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name="role")
    private Role role;

    private List<String> courses;

}
