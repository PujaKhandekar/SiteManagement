package com.registrationBoot.Login_Register.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class SiteCompanyEntities {

	@Id
	private int sideid;
	private String companyid;
	private String companyname;
	private String sitename;
	public int getSideid() {
		return sideid;
	}
	public void setSideid(int sideid) {
		this.sideid = sideid;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
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
	public SiteCompanyEntities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SiteCompanyEntities(int sideid, String companyid, String companyname, String sitename) {
		super();
		this.sideid = sideid;
		this.companyid = companyid;
		this.companyname = companyname;
		this.sitename = sitename;
	}
	@Override
	public String toString() {
		return "SitCompanyEntities [sideid=" + sideid + ", companyid=" + companyid + ", companyname=" + companyname
				+ ", sitename=" + sitename + ", getSideid()=" + getSideid() + ", getCompanyid()=" + getCompanyid()
				+ ", getCompanyname()=" + getCompanyname() + ", getSitename()=" + getSitename() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
