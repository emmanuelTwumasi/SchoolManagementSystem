package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface StudentService {
    Student addStudent(StudentDto studentInfo);

    StudentData getStudentInfo(Long studentId);

    List<StudentData> getStudents();

    void deleteStudent(Long studentId);

    StudentData updateStudentInfo(Long studentId, StudentDto studentDto);

}
