package com.prem.student.controller;

import com.prem.student.model.Customer;
import com.prem.student.model.Student;
import com.prem.student.repository.CustomerRepository;
import com.prem.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private StudentService service;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @GetMapping("/build-info")
    public String getBuildInfo(){
        return buildVersion;
    }

    @GetMapping("/customers/{email}")
    public Optional<Customer> getCustomers(@PathVariable String email){
         return customerRepository.findByEmail(email);
    }
}
