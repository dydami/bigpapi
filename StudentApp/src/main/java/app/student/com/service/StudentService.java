package app.student.com.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import app.student.com.model.StudentDetails;


@Service
public interface StudentService extends UserDetailsService {
	
	
 
	public StudentDetails createStudent(StudentDetails student);

	
		public boolean checkEmail(String email);

		
	}
