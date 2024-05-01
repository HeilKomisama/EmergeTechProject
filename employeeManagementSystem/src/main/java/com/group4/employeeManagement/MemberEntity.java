package com.group4.employeeManagement;

import javax.persistence.*;

@Entity
@Table(name="member")

public class MemberEntity {
	@Id
        //member variables
	private int id;
	private String firstName, lastName, email, contact;
	
        //constructor
	public MemberEntity(int id, String firstName, String lastName, String email, String contact) {
		super();
		this.id=id;
                this.lastName=lastName;
		this.firstName=firstName;
                this.contact=contact;
		this.email=email;
	}
	public MemberEntity() {
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
