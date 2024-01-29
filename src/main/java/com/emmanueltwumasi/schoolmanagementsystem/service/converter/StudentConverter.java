package com.emmanueltwumasi.schoolmanagementsystem.service.converter;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentConverter{

    public Student infoToEntity(StudentDto studentInfo) {
        Student student = new Student();
        student.setFirstName(studentInfo.getFirstName());
        student.setLastName(studentInfo.getLastName());
        student.setUsername(studentInfo.getFirstName().toLowerCase().charAt(0)+studentInfo.getLastName().toLowerCase());
        student.setPassword(studentInfo.getPassword());
        return student;
    }


    public StudentData toDto(Student student) {
        StudentData studentData = new StudentData();
        studentData.setFirstName(student.getFirstName());
        studentData.setLastName(student.getLastName());
        studentData.setUsername(student.getUsername());
        List<String> studentCourses = getStrings(student);
        studentData.setCourses(studentCourses);
        return studentData;
    }

    private List<String> getStrings(Student student) {
        return student.getRegistrations().stream().map(reg->reg.getCourse().getName()).toList();
    }

    public Student updateEntity(StudentDto studentDto, Student student) {
        Student student1 = infoToEntity(studentDto);
        student.setUsername(student1.getUsername());
        student.setFirstName(student1.getFirstName());
        student.setUsername(student1.getLastName());
        return student;
    }
}
