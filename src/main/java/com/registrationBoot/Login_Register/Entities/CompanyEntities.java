package com.registrationBoot.Login_Register.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "companyTable")
public class CompanyEntities {

	@Id
	
	private int id;
	private String companyname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public CompanyEntities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyEntities(int id, String companyname) {
		super();
		this.id = id;
		this.companyname = companyname;
	}
	@Override
	public String toString() {
		return "CompanyEntities [id=" + id + ", companyname=" + companyname + ", getId()=" + getId()
				+ ", getCompanyname()=" + getCompanyname() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
