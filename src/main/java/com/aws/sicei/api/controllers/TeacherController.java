package com.aws.sicei.api.controllers;

import com.aws.sicei.api.models.Teacher;
import com.aws.sicei.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(TeacherController.BASE_URL)
public class TeacherController {
    public static final String BASE_URL = "/profesores";
    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = this.teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@Validated @RequestBody Teacher teacher) {
        Teacher teacherToSave = this.teacherService.saveTeacher(teacher);
        return ResponseEntity.created(URI.create(BASE_URL + "/" +teacherToSave.getId()))
                .body(teacherToSave);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long teacherId) {
        return this.teacherService.getTeacherById(teacherId);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long teacherId) {
        return this.teacherService.deleteTeacher(teacherId);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long teacherId, @Validated @RequestBody Teacher teacher) {
        Teacher teacherToUpdate = this.teacherService.updateTeacher(teacherId, teacher);
        System.out.println("USER ID: " + teacherToUpdate.getId());
        return ResponseEntity.ok(teacherToUpdate);
    }

}
