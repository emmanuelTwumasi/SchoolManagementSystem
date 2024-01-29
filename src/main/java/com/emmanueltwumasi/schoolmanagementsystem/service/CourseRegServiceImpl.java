package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.exception.CourseNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.exception.CourseRegAlreadyExistException;
import com.emmanueltwumasi.schoolmanagementsystem.exception.CourseRegistrationException;
import com.emmanueltwumasi.schoolmanagementsystem.exception.StudentNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRegistrationRepository;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRepository;
import com.emmanueltwumasi.schoolmanagementsystem.repository.StudentRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.CourseRegistrationConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.CourseDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.EnrollmentReq;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.EnrollmentResp;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseRegService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseRegServiceImpl implements CourseRegService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository repository;
    private final CourseRegistrationConverter courseRegistrationConverter;

    @Transactional
    @Override
    public EnrollmentResp registerStudent(Long studentId, EnrollmentReq info) {

        Student student = findStudentById(studentId);

        Course course = findCourseById(info.getCourseId());

        if (repository.existsByStudentStudentIdAndCourseCourseId(studentId, info.getCourseId())) {
            throw new CourseRegAlreadyExistException("Student already registered for this course.");
        }

        CourseRegistration courseRegistration = courseRegistrationConverter.toEntity(course, student);

        repository.save(courseRegistration);

        return courseRegistrationConverter.toDto(courseRegistration);
    }


    @Transactional
    @Override
    public void unEnrollStudent(Long studentId,EnrollmentReq info) {
        CourseRegistration courseRegistration = repository
                .findByStudentStudentIdAndCourseCourseId(studentId, info.getCourseId())
                .orElseThrow(() -> new CourseRegistrationException("Student not registered for this course."));
        repository.delete(courseRegistration);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseRegistration> getStudentEnrollmentInfo(Long studentId) {
        return repository.findAllByStudentStudentId(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<CourseDto> getCourseEnrollmentInfo(Long courseId) {
        findCourseById(courseId);
        return courseRegistrationConverter.toDto(repository.findAllByCourseCourseId(courseId));
    }

    @Override
    @Transactional
    public void deleteStudentEnrollmentById(long studentId) {
        findStudentById(studentId);

        List<CourseRegistration> coursesRegistered = repository.findAllByStudentStudentId(studentId);

        if (coursesRegistered.isEmpty()) {
            throw new CourseRegistrationException("Student not enrolled in any course.");
        }

        repository.deleteAllInBatch(coursesRegistered);
    }

    private Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("No student found"));
    }

    private Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("No course found."));
    }

}
