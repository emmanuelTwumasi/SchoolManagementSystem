package com.emmanueltwumasi.schoolmanagementsystem.service.converter;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {
    public Course toEntity(CourseInfo courseInfo) {
        Course course  =  new Course();
        course.setName(courseInfo.getName());
        course.setDescription(courseInfo.getDescription());
        course.setCode(courseInfo.getCode());
        return course;
    }

    public CourseInfo toDto(Course courseInfo) {
        CourseInfo course  =  new CourseInfo();
        course.setName(courseInfo.getName());
        course.setDescription(courseInfo.getDescription());
        course.setCode(courseInfo.getCode());
        return course;
    }
}
