package com.spp.demo.helloworld.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<StudentVO> students = List.of(StudentVO.builder()
            .dob("31/May/1985")
            .name("Ajay Devgan")
            .rollNumber("05426")
            .uniqueId("hero-number-one")
            .build());

    public List<StudentVO> getStudents() {
        return students;
    }

    public Optional<StudentVO> getStudentById(String uniqueId) {
        return students.stream().filter(studentVO -> studentVO.getUniqueId().equals(uniqueId)).findFirst();
    }
}
