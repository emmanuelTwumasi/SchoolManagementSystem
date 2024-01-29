package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;

import java.util.List;


public interface StudentService {
    void addStudent(StudentDto studentInfo);

    StudentData getStudentInfo(Long studentId);

    List<StudentData> getStudents();

    void deleteStudent(Long studentId);

    StudentData updateStudentInfo(Long studentId, StudentDto studentDto);


}
