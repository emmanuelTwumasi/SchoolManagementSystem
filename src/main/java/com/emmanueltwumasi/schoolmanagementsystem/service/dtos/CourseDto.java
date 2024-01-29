package com.emmanueltwumasi.schoolmanagementsystem.service.dtos;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.CourseInfo;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentCommon;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentData;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto extends CourseInfo {
    List<StudentCommon> students;
}
