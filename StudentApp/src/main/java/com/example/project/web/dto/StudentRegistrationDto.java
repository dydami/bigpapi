package com.example.project.web.dto;

public class StudentRegistrationDto {
public String firstName;
public String lastName;
public String email;
public String password;

public StudentRegistrationDto() {
	
}

public StudentRegistrationDto(String firstName, String lastName, String email, String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
