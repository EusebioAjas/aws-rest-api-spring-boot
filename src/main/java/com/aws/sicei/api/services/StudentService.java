package com.aws.sicei.api.services;

import com.aws.sicei.api.models.Student;
import com.aws.sicei.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return ResponseEntity.ok().body(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    public Student updateStudent(Long studentId, Student newStudent) {
        return studentRepository.findById(studentId).map(student -> {
                    student.setNombres(newStudent.getNombres());
                    student.setApellidos(newStudent.getApellidos());
                    student.setPromedio(newStudent.getPromedio());
                    student.setMatricula(newStudent.getMatricula());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(studentId);
                    return studentRepository.save(newStudent);
                });
    }

    public ResponseEntity<Student> deleteStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            studentRepository.deleteById(studentId);
            return ResponseEntity.ok().body(student.get());
        }
        return ResponseEntity.notFound().build();
    }
}
