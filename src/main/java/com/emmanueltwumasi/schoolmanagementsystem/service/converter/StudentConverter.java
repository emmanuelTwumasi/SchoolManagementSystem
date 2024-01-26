package com.emmanueltwumasi.schoolmanagementsystem.service.converter;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.responsedto.StudentData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentConverter{

    public Student infoToEntity(StudentDto studentInfo) {
        Student student = new Student();
        student.setFirstName(student.getFirstName());
        student.setLastname(student.getLastname());
        student.setPassword(studentInfo.getPassword());
        student.setRole(studentInfo.getRole());
        return student;
    }


    public StudentData toDto(Student student) {
        StudentData studentData = new StudentData();
        studentData.setFirstName(student.getFirstName());
        studentData.setLastname(student.getLastname());
        studentData.setUsername(student.getUsername());
        List<String> studentCourses = getStrings(student);
        studentData.setCourses(studentCourses);
        return studentData;
    }

    private List<String> getStrings(Student student) {
        return student.getCourseList().stream().map(Course::getName).toList();
    }
}
