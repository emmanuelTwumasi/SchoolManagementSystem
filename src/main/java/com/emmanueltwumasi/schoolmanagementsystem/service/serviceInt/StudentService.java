package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;

import java.util.List;


public interface StudentService {
    public void addStudent(StudentDto studentInfo);
    public StudentData getStudentInfo(Long studentId);
    public List<StudentData> getStudents();

    public EnrollmentResp registerStudent(EnrollmentReq info);
}
