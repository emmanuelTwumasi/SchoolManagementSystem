package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;

import java.util.List;
import java.util.Map;

public interface CourseService {
    public void addCourse(CourseInfo courseInfo);
    public List<CourseInfo> fetchAllCourses();

    public CourseInfo getCourse(Long courseId);

    Course updateCourse(Long id, CourseInfo courseInfo);

    void deleteCourse(Long id);
    ;
}
