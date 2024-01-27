package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Course;
import com.emmanueltwumasi.schoolmanagementsystem.repository.CourseRepository;
import com.emmanueltwumasi.schoolmanagementsystem.service.CourseServiceImpl;
import com.emmanueltwumasi.schoolmanagementsystem.service.converter.CourseConverter;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



public class CourseServiceTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseConverter courseConverter;

    @Autowired
    private CourseService courseService;


    @Before
    public void setUp() throws Exception {
        courseService = new CourseServiceImpl(courseRepository,courseConverter);
    }

    @Test
    public void addCourse() {
        CourseInfo courseInfo = new CourseInfo();
        when(courseRepository.save(new Course())).thenReturn(new Course());
        when(courseConverter.toEntity(courseInfo)).thenReturn(new Course());
        courseService.addCourse(courseInfo);
    }

    @Test
    public void fetchAllCourses() {

    }

    @Test
    public void getCourse() {
        when(courseRepository.findById(any())).thenReturn(Optional.of(new Course()));
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setName("New course");
        when(courseConverter.toDto(any())).thenReturn(courseInfo);
        var a = courseService.getCourse(any());
        assertThat(a.getName()).isNotNull();
    }
}