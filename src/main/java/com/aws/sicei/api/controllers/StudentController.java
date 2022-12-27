package com.aws.sicei.api.controllers;


import com.aws.sicei.api.models.Student;
import com.aws.sicei.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = StudentController.BASE_URL)
public class StudentController {
    static final String BASE_URL = "/alumnos";
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = this.studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent( @Validated @RequestBody Student student){
        Student savedStudent =  this.studentService.saveStudent(student);
        return ResponseEntity.created(URI.create(BASE_URL + savedStudent.getId()))
                .body(savedStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable(value = "studentId") Long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId){
        return this.studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @Validated @RequestBody Student student ){
        Student updatedStudent = this.studentService.updateStudent(studentId, student);
        return ResponseEntity.ok(updatedStudent);
    }
}
