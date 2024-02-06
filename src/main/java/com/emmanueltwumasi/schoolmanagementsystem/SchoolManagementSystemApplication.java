package com.emmanueltwumasi.schoolmanagementsystem;

import com.emmanueltwumasi.schoolmanagementsystem.config.openapi_config.SpringSecurityAuditorAware;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchoolManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}
//	@Bean
//	AuditorAware<Student> auditorProvider() {
//		return new SpringSecurityAuditorAware();
//	}
}
