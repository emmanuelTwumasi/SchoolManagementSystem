package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.service.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.StudentDto;

import java.util.List;


public interface StudentService {
    public void addStudent(StudentDto studentInfo);
    public StudentData getStudentInfo(Long studentId);
    public List<StudentData> getStudents();
}
