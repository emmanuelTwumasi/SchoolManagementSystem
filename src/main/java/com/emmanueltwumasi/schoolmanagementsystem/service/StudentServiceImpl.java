package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRegistrationRepository;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRepository;
import com.emmanueltwumasi.schoolmanagementsystem.repository.StudentRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.CourseRegistrationConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.StudentConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.exception.CourseNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.service.exception.StudentNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentConverter studentConverter;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRegistrationConverter courseRegistrationConverter;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStudent(StudentDto studentInfo) {
        Student student = studentConverter.infoToEntity(studentInfo);
        repository.save(student);
    }

    @Override
    public StudentData getStudentInfo(Long studentId) {
        return studentConverter.toDto(findStudentById(studentId));
    }

    @Override
    public List<StudentData> getStudents() {
        return repository.findAll()
                .stream()
                .map(studentConverter::toDto)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EnrollmentResp registerStudent(EnrollmentReq info) {
        if (info == null) return null;

        Student student = findStudentById(info.getStudentId());

        Course course = courseRepository.findById(info.getCourseId())
                .orElseThrow(()->new CourseNotFoundException("No course found."));

        CourseRegistration courseRegistration = courseRegistrationConverter.toEntity(course, student);

        courseRegistrationRepository.save(courseRegistration);

        return courseRegistrationConverter.toDto(courseRegistration);
    }

    private Student findStudentById(Long studentId) {
        return repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("No student found"));
    }


}
