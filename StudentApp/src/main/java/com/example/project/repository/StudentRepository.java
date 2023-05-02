package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Students;



@Repository
public interface StudentRepository extends JpaRepository<Students, Long>{
Students findByEmail(String email);
	Students save(Students student); }