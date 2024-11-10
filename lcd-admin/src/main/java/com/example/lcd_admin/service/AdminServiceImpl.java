package com.example.lcd_admin.service;

import com.example.lcd_admin.dto.CourseRequestDto;
import com.example.lcd_admin.dto.EmployeeCredentialsDto;
import com.example.lcd_admin.dto.AssignCourseDto;
import com.example.lcd_admin.entity.Course;
import com.example.lcd_admin.entity.Employee;
import com.example.lcd_admin.entity.CourseAssignment;
import com.example.lcd_admin.repository.CourseRepository;
import com.example.lcd_admin.repository.EmployeeRepository;
import com.example.lcd_admin.repository.CourseAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CourseAssignmentRepository courseAssignmentRepository;

    @Override
    public void createCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setCourseName(courseRequestDto.getCourseName());
        course.setDescription(courseRequestDto.getDescription());
        course.setIsActive(true);
        courseRepository.save(course);
    }

    @Override
    public void generateEmployeeCredentials(EmployeeCredentialsDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        employeeRepository.save(employee);
    }

    @Override
    public void assignCourseToEmployee(AssignCourseDto assignCourseDto) {
        Course course = courseRepository.findById(assignCourseDto.getCourseId()).orElseThrow();
        Employee employee = employeeRepository.findById(assignCourseDto.getEmployeeId()).orElseThrow();
        CourseAssignment assignment = new CourseAssignment();
        assignment.setCourse(course);
        assignment.setEmployee(employee);
        courseAssignmentRepository.save(assignment);
    }
}
