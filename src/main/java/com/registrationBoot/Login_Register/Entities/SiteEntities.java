package com.registrationBoot.Login_Register.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table (name = "SiteTable")
@DynamicInsert
public class SiteEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Size(min=5, message = "company name is required")
	private String companyname;
	
	@NotEmpty
	private String sitename;
	
	@NotEmpty
	private String place;
	
	@NotEmpty
	private String owner;

	
	private Double fixedamount;
	
//	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatdate;
	
	@PrePersist
	private void onCreate() {
		creatdate = new Date();
	}
	
//	@NotEmpty
//	@Value ("${SiteEntities.deletestatus}")
//	@ColumnDefault("0")
	private String deletestatus;
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
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Double getFixedamount() {
		return fixedamount;
	}
	public void setFixedamount(Double fixedamount) {
		this.fixedamount = fixedamount;
	}
	public Date getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	public String getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}
	public SiteEntities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SiteEntities(int id, String companyname, String sitename, String place, String owner, Double fixedamount,
			Date creatdate, String deletestatus) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.sitename = sitename;
		this.place = place;
		this.owner = owner;
		this.fixedamount = fixedamount;
		this.creatdate = creatdate;
		this.deletestatus = deletestatus;
	}
	@Override
	public String toString() {
		return "SiteEntities [id=" + id + ", companyname=" + companyname + ", sitename=" + sitename + ", place=" + place
				+ ", owner=" + owner + ", fixedamount=" + fixedamount + ", creatdate=" + creatdate + ", deletestatus="
				+ deletestatus + ", getId()=" + getId() + ", getCompanyname()=" + getCompanyname() + ", getSitename()="
				+ getSitename() + ", getPlace()=" + getPlace() + ", getOwner()=" + getOwner() + ", getFixedamount()="
				+ getFixedamount() + ", getCreatdate()=" + getCreatdate() + ", getDeletestatus()=" + getDeletestatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
