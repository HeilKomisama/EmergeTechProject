package com.group4.employeeManagement;

import javax.persistence.*;

@Entity
@Table(name="employee")

public class EmployeeEntity {
	@Id
        //member variables
	private int id;
	private String firstName, lastName, email, department, contact;
	
        //constructor
	public EmployeeEntity(int id, String firstName, String lastName, String email, String contact, String department) {
		super();
		this.id=id;
        this.lastName=lastName;
		this.firstName=firstName;
        this.contact=contact;
		this.department=department;
		this.email=email;
	}
	public EmployeeEntity() {
		super();
	}
	
        //Methods
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
        
        public String getContact() {
		return contact;
	}
	
	public void setDepartment(String department) {
		this.department=department;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setContact(String contact) {
		this.contact=contact;
	}
	
	public String getfName() {
		return firstName;
	}
	public void setfName(String firstName) {
		this.firstName=firstName;
	}
        
        public String getlName() {
		return lastName;
	}
	public void setlName(String lastName) {
		this.lastName=lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	
	
	
	
}
