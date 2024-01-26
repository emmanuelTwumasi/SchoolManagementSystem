package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.CourseInfo;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    public ResponseEntity<HttpStatus> addCourse(CourseInfo courseInfo) {
        courseService.addCourse(courseInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<List<CourseInfo>> fetchAllCourses() {
        return new ResponseEntity<>(courseService.fetchAllCourses(), HttpStatus.OK);
    }
    public ResponseEntity<CourseInfo> getCourse(Long courseId) {
        return new ResponseEntity<>(courseService.getCourse(courseId), HttpStatus.OK);
    }

}
