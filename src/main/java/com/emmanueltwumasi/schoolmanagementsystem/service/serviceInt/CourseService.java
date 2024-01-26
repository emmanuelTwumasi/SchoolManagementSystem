package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.CourseInfo;

import java.util.List;

public interface CourseService {
    public void addCourse(CourseInfo courseInfo);
    public List<CourseInfo> fetchAllCourses();

    public CourseInfo getCourse(Long courseId);
}
