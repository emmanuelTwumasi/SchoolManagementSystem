package com.emmanueltwumasi.schoolmanagementsystem.service.converter;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.CourseDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentCommon;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
        System.out.println(courseRegistration);
        return courseRegistration;
    }

    public Collection<CourseDto> toDto(List<CourseRegistration> courseRegistrations) {
        if(courseRegistrations.isEmpty()){
            return null;
        }
        HashMap<Long, CourseDto> hashMap = new HashMap<>();
        for (CourseRegistration courseRegistration:courseRegistrations){
                CourseDto courseDto =  hashMap.getOrDefault(courseRegistration.getCourse().getCourseId(),new CourseDto());
                StudentCommon student = new StudentCommon();
                student.setFirstName(courseRegistration.getStudent().getFirstName());
                student.setLastName(courseRegistration.getStudent().getLastName());
                courseDto.getStudents().add(student);
        }
            return hashMap.values();
    }
}
