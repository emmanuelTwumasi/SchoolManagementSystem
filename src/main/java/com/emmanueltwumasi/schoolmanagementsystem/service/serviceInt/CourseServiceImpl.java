package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.exception.CourseNotFoundException;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.CourseService;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.CourseConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;


    @Override
    @Transactional
    @CachePut(value = "courses", key = "#result.id")
    public Course addCourse(CourseInfo courseInfo) {
        Course course = courseConverter.toEntity(courseInfo);
       return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "courses")
    public List<CourseInfo> fetchAllCourses() {
        return courseRepository.findAll().stream().peek(System.err::println).map(courseConverter::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "courses", key = "#id")
    public CourseInfo getCourse(Long courseId) {
        return courseRepository.findById(courseId).map(courseConverter::toDto)
                .orElseThrow(() -> new CourseNotFoundException("No course found."));
    }

    @Override
    @Transactional
    @CachePut(value = "courses", key = "#id")
    public Course updateCourse(Long id, CourseInfo courseInfo) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with id: " + id);
        }
        Course course = courseConverter.toEntity(courseInfo);
        course.setCourseId(id);
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    @CacheEvict(value = "courses", key = "#id")
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

}