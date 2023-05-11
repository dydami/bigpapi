package app.student.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.student.com.model.StudentDetails;


@Repository
public interface StudentRepository extends JpaRepository< StudentDetails, Integer> {

	public boolean existsByEmail(String email);

	public StudentDetails findByEmail(String email);

}

