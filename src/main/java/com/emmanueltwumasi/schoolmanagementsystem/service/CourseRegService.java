package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.CourseDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;

import java.util.Collection;
import java.util.List;

public interface CourseRegService {
    EnrollmentResp registerStudent(Long studentId, EnrollmentReq info);

    void unEnrollStudent(Long studentId, EnrollmentReq info);

    List<CourseRegistration> getStudentEnrollmentInfo(Long studentId);

    Collection<CourseDto> getCourseEnrollmentInfo(Long courseId);

    void deleteStudentEnrollmentById(long studentId);
}
