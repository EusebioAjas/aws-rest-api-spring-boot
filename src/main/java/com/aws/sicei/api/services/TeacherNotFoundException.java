package com.aws.sicei.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Teacher not found")
public class TeacherNotFoundException extends RuntimeException  {
    public TeacherNotFoundException(Long studentId) {
        super("Student with id: "+ studentId + "doesn't exist");
    }
}
