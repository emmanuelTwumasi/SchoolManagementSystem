package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.CourseDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseRegService;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/courses")
@RequiredArgsConstructor
@Tag(name= "Course Management")
public class CourseController {
    private final CourseService courseService;
    private final CourseRegService courseRegService;

    @Operation(summary = "Add a course.")
    @PostMapping
    public ResponseEntity<HttpStatus> addCourse(@RequestBody CourseInfo courseInfo) {
        courseService.addCourse(courseInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "Get all courses.")
    @GetMapping
    public ResponseEntity<List<CourseInfo>> fetchAllCourses() {
        return new ResponseEntity<>(courseService.fetchAllCourses(), HttpStatus.OK);
    }
    @Operation(summary = "Get a course.")
    @GetMapping("{courseId}")
    public ResponseEntity<CourseInfo> getCourse(@PathVariable("courseId") Long courseId) {
        return new ResponseEntity<>(courseService.getCourse(courseId), HttpStatus.OK);
    }
    @GetMapping("{course-id}/enrollment")
    public ResponseEntity<Collection<CourseDto>> getCourseEnrollmentInfo(@PathVariable("course-id")Long courseId){
        return new ResponseEntity<>(courseRegService.getCourseEnrollmentInfo(courseId),HttpStatus.OK);
    }

}
