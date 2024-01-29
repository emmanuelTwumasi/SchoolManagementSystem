package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.repository.StudentRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.StudentConverter;
import com.emmanueltwumasi.schoolmanagementsystem.exception.StudentNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseRegService;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentConverter studentConverter;


    @Transactional
    @Override
    @CachePut(value = "students", key = "#result.id")
    public void addStudent(StudentDto studentInfo) {
        Student student = studentConverter.infoToEntity(studentInfo);
        repository.save(student);
    }

    @Override
    @Cacheable(value = "students", key = "#id")
    public StudentData getStudentInfo(Long studentId) {
        return studentConverter.toDto(findStudentById(studentId));
    }

    @Override
    @Cacheable(value = "students")
    public List<StudentData> getStudents() {
        return repository.findAll()
                .stream()
                .map(studentConverter::toDto)
                .toList();
    }

    @Override
    @CachePut(value = "students", key = "#id")
    public void deleteStudent(Long studentId) {
        Student student= findStudentById(studentId);
        repository.delete(student);
    }

    @Override
    @CachePut(value = "students", key = "#id")
    public StudentData updateStudentInfo(Long studentId, StudentDto studentDto) {
       Student student =  findStudentById(studentId);
       Student updated = studentConverter.updateEntity(studentDto,student);
       return studentConverter.toDto(repository.save(updated));
    }

    private Student findStudentById(Long studentId) {
        return repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("No student found"));
    }

}
