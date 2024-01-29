package com.emmanueltwumasi.schoolmanagementsystem.repository;

import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Long> {
    Optional<CourseRegistration> findByStudentStudentIdAndCourseCourseId(Long student_id,Long course_id);
    Boolean existsByStudentStudentIdAndCourseCourseId(Long student_id,Long course_id);

    List<CourseRegistration> findAllByStudentStudentId(Long student_id);
    void deleteAllByStudentStudentId(Long student_id);
    void deleteAllByCourseCourseId(Long course_id);
    List<CourseRegistration> findAllByCourseCourseId(Long courseId);
}
