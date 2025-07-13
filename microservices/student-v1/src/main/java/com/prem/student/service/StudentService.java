package com.prem.student.service;

import com.prem.student.model.Student;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setAge(updatedStudent.getAge());
                return s;
            }
        }
        return null;
    }
}
