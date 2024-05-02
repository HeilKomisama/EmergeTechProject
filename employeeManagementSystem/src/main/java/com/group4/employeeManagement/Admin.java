package com.group4.employeeManagement;

import javax.persistence.*;

@Entity
@Table(name="admin")

public class Admin {
	@Id
        //member variables
	private int id;
	private String user,password;
	
        //constructor
	public Admin(int id, String user, String password) {
		super();
		this.id=id;
        this.user=user;
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
        
        public String getUser() {
		return user;
	}
	
    public String getPassword(String user) {
		if(this.user==user){
            return password;
        }
        return "";
        
	}


    public void setUser(String user) {
		this.user=user;
	}

    public void setPassword(String password) {
		this.password=password;
	}
	
	
	
	
	
}
