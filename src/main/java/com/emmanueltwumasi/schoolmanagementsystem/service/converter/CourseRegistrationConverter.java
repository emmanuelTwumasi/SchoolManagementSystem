package com.emmanueltwumasi.schoolmanagementsystem.service.converter;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CourseRegistrationConverter {
    public EnrollmentResp toDto(CourseRegistration courseRegistration) {
        EnrollmentResp enrollmentResp = new EnrollmentResp();
        enrollmentResp.setUsername(courseRegistration.getStudent().getUsername());
        enrollmentResp.setCourse(courseRegistration.getCourse().getName());
        return enrollmentResp;
    }

    public CourseRegistration toEntity(Course course, Student student) {
        CourseRegistration courseRegistration =  new CourseRegistration();
        courseRegistration.setCourse(course);
        courseRegistration.setStudent(student);
        courseRegistration.setRegistrationDate(LocalDateTime.now());
        return courseRegistration;
    }
}
