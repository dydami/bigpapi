package com.example.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.model.Role;
import com.example.project.model.Students;
import com.example.project.repository.StudentRepository;
import com.example.project.web.dto.StudentRegistrationDto;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

  
    
    @Override
    public Students save(StudentRegistrationDto registrationDto) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_USER"));
        Students student = new Students(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), roles);
        return studentRepository.save(student);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Students student = studentRepository.findByEmail(username);
        if (student == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
           return new User(student.getEmail(), student.getPassword(), mapRolesToAuthorities(student.getRoles()));
    }
    
    
    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}