package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.service.CourseRegService;
import com.emmanueltwumasi.schoolmanagementsystem.service.StudentService;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping(value = "api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Student Management")
public class StudentController {

    private final StudentService studentService;
    private final CourseRegService courseRegService;

    @Operation(summary = "Get all courses..")
    @GetMapping
    public ResponseEntity<List<StudentData>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @Operation(summary = "Get a student by id.")
    @GetMapping("/{id}")
    public ResponseEntity<StudentData> getStudentInfo(@PathVariable("id") Long studentId) {

        StudentData studentInfo = studentService.getStudentInfo(studentId);

        List<CourseRegistration> studentEnrollmentInfo = this.courseRegService.getStudentEnrollmentInfo(studentId);

        if (studentEnrollmentInfo.isEmpty()) {
            return new ResponseEntity<>(studentInfo, HttpStatus.OK);
        }

        studentInfo.getCourses().addAll(studentEnrollmentInfo.stream().map(e -> e.getCourse().getName()).toList());
        return new ResponseEntity<>(studentInfo, HttpStatus.OK);
    }

    @Operation(summary = "Add a new student.")
    @PostMapping("student")
    public ResponseEntity<HttpStatus> addNewStudent(@RequestBody @Valid StudentDto studentInfo) {
        studentService.addStudent(studentInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update student data.")
    @PostMapping("/{id}")
    public ResponseEntity<StudentData> updateStudentInfo(@PathVariable("id") Long studentId, @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudentInfo(studentId, studentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete student from system.")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudentData(@PathVariable("id") Long studentId) {
        this.courseRegService.deleteStudentEnrollmentById(studentId);
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Register student for a course.")
    @PostMapping("{id}/enroll")
    public ResponseEntity<EnrollmentResp> registerStudent(@PathVariable("id") Long studentId, @RequestBody @Valid EnrollmentReq info) {
        return new ResponseEntity<>(courseRegService.registerStudent(studentId, info), HttpStatus.CREATED);
    }

    @Operation(summary = "Un-roll student from a course")
    @PostMapping("{id}/un-enroll")
    public ResponseEntity<HttpStatus> unEnrollStudent(@PathVariable("id") Long studentId, @RequestBody @Valid EnrollmentReq info) {
        courseRegService.unEnrollStudent(studentId, info);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

