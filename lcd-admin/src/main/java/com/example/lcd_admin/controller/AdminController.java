package com.example.lcd_admin.controller;

import com.example.lcd_admin.dto.CourseRequestDto;
import com.example.lcd_admin.dto.EmployeeCredentialsDto;
import com.example.lcd_admin.dto.AssignCourseDto;
import com.example.lcd_admin.entity.Employee;
import com.example.lcd_admin.service.AdminService;
import com.example.lcd_admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-course")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        adminService.createCourse(courseRequestDto);
        return ResponseEntity.ok("Course created successfully.");
    }

    @PostMapping("/generate-employee")
    public ResponseEntity<String> generateEmployee(@RequestBody EmployeeCredentialsDto employeeDto) {
        adminService.generateEmployeeCredentials(employeeDto);
        return ResponseEntity.ok("Employee credentials generated successfully.");
    }


    @PostMapping("/assign-course")
    public ResponseEntity<String> assignCourse(@RequestBody AssignCourseDto assignCourseDto) {
        adminService.assignCourseToEmployee(assignCourseDto);
        return ResponseEntity.ok("Course assigned successfully.");
    }


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok("Employee updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}