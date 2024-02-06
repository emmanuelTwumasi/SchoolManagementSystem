package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.service.CourseRegService;
import com.emmanueltwumasi.schoolmanagementsystem.service.CourseService;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.APiResponse;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.CourseDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping(value = "api/v1/courses")
@RequiredArgsConstructor
@Tag(name = "Course Management")
public class CourseController {
    private final CourseService courseService;
    private final CourseRegService courseRegService;

    @Operation(summary = "Add a course.")
    @PostMapping
    public ResponseEntity<APiResponse<Course>> addCourse(@RequestBody CourseInfo courseInfo) {
       Course course = courseService.addCourse(courseInfo);
       return new ResponseEntity<>(
               new APiResponse<>("Course added successfully." , true , CREATED.value() , course),
               CREATED);
    }

    @Operation(summary = "Get all courses.")
    @GetMapping
    public ResponseEntity<APiResponse<List<CourseInfo>>> fetchAllCourses() {
        List<CourseInfo> courses = courseService.fetchAllCourses();
        return new ResponseEntity<>(new APiResponse<>("Courses retrieved." , true , OK.value() , courses) , HttpStatus.OK);
    }

    @Operation(summary = "Get a course.")
    @GetMapping("{courseId}")
    public ResponseEntity<APiResponse<CourseInfo>> getCourse(@PathVariable("courseId") Long courseId) {
        CourseInfo course = courseService.getCourse(courseId);
        return new ResponseEntity<>(new APiResponse<>("Course",true, OK.value() , course) , HttpStatus.OK);
    }

    @GetMapping("{course-id}/enrollment")
    public ResponseEntity<APiResponse<Collection<CourseDto>>> getCourseEnrollmentInfo(@PathVariable("course-id") Long courseId) {
        Collection<CourseDto> enrollmentInfo = courseRegService.getCourseEnrollmentInfo(courseId);
        return new ResponseEntity<>(new APiResponse<>("Course Enrollment",true, OK.value() , enrollmentInfo) , HttpStatus.OK);
    }

}
