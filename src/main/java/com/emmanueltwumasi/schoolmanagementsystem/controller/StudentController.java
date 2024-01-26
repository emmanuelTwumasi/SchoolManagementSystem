package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentData>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentData> getStudentInfo(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentService.getStudentInfo(studentId), HttpStatus.OK);
    }
    @PostMapping("student")
    public ResponseEntity<HttpStatus> addNewStudent(@RequestBody @Valid StudentDto studentInfo) {
        studentService.addStudent(studentInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
