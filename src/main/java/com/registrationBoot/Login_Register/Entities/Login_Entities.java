package com.registrationBoot.Login_Register.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table (name="LoginRegister")
public class Login_Entities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String password;
	private String mobileno;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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
 
	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public Login_Entities() {
		super();
		// TODO Auto-generated constructor stub
	}

		

		public Login_Entities(int id, String username, String email, String password, String mobileno) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileno = mobileno;
	}


		
}
