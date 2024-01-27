package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.CourseConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.exception.CourseNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCourse(CourseInfo courseInfo) {
        Course course = courseConverter.toEntity(courseInfo);
        courseRepository.save(course);
    }

    @Override
    public List<CourseInfo> fetchAllCourses() {
        return courseRepository.findAll().stream().map(courseConverter::toDto).toList();
    }

    @Override
    public CourseInfo getCourse(Long courseId) {
        return courseRepository.findById(courseId).map(courseConverter::toDto)
                .orElseThrow(()->new CourseNotFoundException("No course found."));
    }
}
