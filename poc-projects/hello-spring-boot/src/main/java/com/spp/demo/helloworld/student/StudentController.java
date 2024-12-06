package com.spp.demo.helloworld.student;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentVO>> getAll() {
//        return studentService.getStudents();
        return new ResponseEntity<>(studentService.getStudents(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentVO> getById(@PathVariable String id) {
        StudentVO studentVO= studentService.getStudentById(id).orElseThrow(() -> {
            String message="No details found for id: " + id;
            System.out.println(message);
             return new IllegalArgumentException(message);
        });
        return new ResponseEntity<>(studentVO, HttpStatusCode.valueOf(200));
    }
}
