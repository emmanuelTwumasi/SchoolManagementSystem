package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.repository.StudentRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.StudentConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.exception.StudentNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.service.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentConverter studentConverter;

    @Override
    public void addStudent(StudentDto studentInfo) {
        Student student = studentConverter.infoToEntity(studentInfo);
        repository.save(student);
    }

    @Override
    public StudentData getStudentInfo(Long studentId) {
        return repository.findById(studentId).map(studentConverter::toDto)
                .orElseThrow(()->new StudentNotFoundException("No student found"));
    }

    @Override
    public List<StudentData> getStudents() {
        return repository.findAll().stream().map(studentConverter::toDto).toList();
    }
}
