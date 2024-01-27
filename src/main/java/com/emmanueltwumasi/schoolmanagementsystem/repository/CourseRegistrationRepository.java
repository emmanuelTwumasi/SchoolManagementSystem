package com.emmanueltwumasi.schoolmanagementsystem.repository;

import com.emmanueltwumasi.schoolmanagementsystem.entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Long> {
}
