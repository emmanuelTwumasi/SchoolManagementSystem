package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;

import java.util.List;

public interface CourseService {
    Course addCourse(CourseInfo courseInfo);
    List<CourseInfo> fetchAllCourses();

    CourseInfo getCourse(Long courseId);

    Course updateCourse(Long id, CourseInfo courseInfo);

    void deleteCourse(Long id);
}
