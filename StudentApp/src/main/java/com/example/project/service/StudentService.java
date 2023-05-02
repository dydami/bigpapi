package com.example.project.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.project.model.Students;
import com.example.project.web.dto.StudentRegistrationDto;



public interface StudentService extends UserDetailsService {
Students save(StudentRegistrationDto registrationDto);
}