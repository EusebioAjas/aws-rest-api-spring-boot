package com.aws.sicei.api.services;

import com.aws.sicei.api.models.Student;
import com.aws.sicei.api.models.Teacher;
import com.aws.sicei.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public ResponseEntity<Teacher> getTeacherById(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isPresent()) {
            return ResponseEntity.ok().body(teacher.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Teacher> deleteTeacher(Long teacherId) {
        Optional<Teacher> teacherToDelete = this.teacherRepository.findById(teacherId);
        if(teacherToDelete.isPresent()){
            teacherRepository.deleteById(teacherId);
            return ResponseEntity.ok().body(teacherToDelete.get());
        }
        return ResponseEntity.notFound().build();
    }
    public Teacher updateTeacher(Long teacherId, Teacher newTeacher) {
        return this.teacherRepository.findById(teacherId).map(teacher -> {
            teacher.setNumeroEmpleado(newTeacher.getNumeroEmpleado());
            teacher.setNombres(newTeacher.getNombres());
            teacher.setApellidos(newTeacher.getApellidos());
            teacher.setHorasClase(newTeacher.getHorasClase());
            return teacherRepository.save(teacher);
        }).orElseGet(()-> {
            newTeacher.setId(teacherId);
            return teacherRepository.save(newTeacher);
        });
    }
}
