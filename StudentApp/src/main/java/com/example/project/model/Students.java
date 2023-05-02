package com.example.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(name = "Student", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Students {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    
	    @Column(name = "first_name")
		private String firstName;
	  
	    @Column(name = "last_name")
		private String lastName;
		
		private String email;
		
		private String password;
		
		@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(
				name = "student_roles",
				joinColumns = @JoinColumn(
						name = "student_id", referencedColumnName = "id" ),
				inverseJoinColumns = @JoinColumn(
						name = "role_id", referencedColumnName = "id")	
				
				)
		private List<Role>roles;
	
		
		public Students() {
			
		}
		
		public Students (String firstName, String lastName, String email, String password, List<Role> roles) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.roles = roles;
		}
		
		public long getID() {
			return id;
		}
		public void setID(long iD) {
			id = iD;
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
		public List<Role> getRoles() {
			return roles;
		}
		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}
		
}
