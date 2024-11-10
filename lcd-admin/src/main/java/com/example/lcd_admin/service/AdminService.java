package com.example.lcd_admin.service;

import com.example.lcd_admin.dto.CourseRequestDto;
import com.example.lcd_admin.dto.EmployeeCredentialsDto;
import com.example.lcd_admin.dto.AssignCourseDto;

public interface AdminService {
    void createCourse(CourseRequestDto courseRequestDto);
    void generateEmployeeCredentials(EmployeeCredentialsDto employeeDto);
    void assignCourseToEmployee(AssignCourseDto assignCourseDto);
}
