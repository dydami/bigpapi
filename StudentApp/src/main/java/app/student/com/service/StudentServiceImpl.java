package app.student.com.service;

import app.student.com.model.StudentDetails;
import app.student.com.repository.StudentRepository;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import org.springframework.beans.factory.annotation.Autowired;


@Component
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;

  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


  
  @Override
  public StudentDetails createStudent(StudentDetails student) {
	  StudentDetails studentCheck = studentRepository.findByEmail(student.getEmail());
      if(studentCheck != null) throw  new RuntimeException("Data exist");
      if(student.getPassword() != null && !(student.getPassword()).equals("")){
    	  student.setPassword(passwordEncoder.encode(student.getPassword()));
      }
     
      StudentDetails persistedStudent = studentRepository.save(student);
      
      return persistedStudent;
  }

  @Override
  public boolean checkEmail(String email) {
   
    return studentRepository.findByEmail(email) != null;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  StudentDetails student = studentRepository.findByEmail(username);
      if(student != null){
          return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), new ArrayList<>());
      }
      throw new UsernameNotFoundException("user not found");  }
}