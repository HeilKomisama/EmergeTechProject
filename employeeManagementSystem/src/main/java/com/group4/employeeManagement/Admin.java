package com.group4.employeeManagement;

import javax.persistence.*;

@Entity
@Table(name="admin")

public class Admin {
	@Id
        //member variables
	private int id;
	private String email,password;
	
        //constructor
	public Admin(int id,String email, String password) {
            super();
            this.id=id;
            this.email=email;
            this.password=password;
	}
	public Admin() {
		super();
	}
	
        //Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
        public String getEmail() {
		return email;
	}
    public String getPassword(String email) {
		if(this.email==email){
            return password;
        }
        return "";
        
	}
    public void setPassword(String password) {
		this.password=password;
	}
	
	
	
	
	
}
