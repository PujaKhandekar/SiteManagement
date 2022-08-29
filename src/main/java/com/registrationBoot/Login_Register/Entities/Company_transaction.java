package com.registrationBoot.Login_Register.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Company_transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionid;
	
	@NotEmpty
	@Size(min=5, message = "Company name is required")
	private String companyname;
	
	@NotEmpty
	@Size(min=5, message = "Ledger name is required")
	private String ledgername;
	
	@NotEmpty
	@Size(min=5, message = "Transaction value is required")
	private double transactionvalue;

	public Company_transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatdate;
	
	@PrePersist
	private void onCreate() {
		creatdate = new Date();
	}
	

	public Date getCreatdate() {
		return creatdate;
	}


	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}


	public Company_transaction(int transactionid, String companyname, String ledgername, double transactionvalue, Date creatdate) {
		super();
		this.transactionid = transactionid;
		this.companyname = companyname;
		this.ledgername = ledgername;
		this.transactionvalue = transactionvalue;
		this.creatdate = creatdate;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getLedgername() {
		return ledgername;
	}

	public void setLedgername(String ledgername) {
		this.ledgername = ledgername;
	}

	public double getTransactionvalue() {
		return transactionvalue;
	}

	public void setTransactionvalue(double transactionvalue) {
		this.transactionvalue = transactionvalue;
	}

	@Override
	public String toString() {
		return "Company_transaction [transactionid=" + transactionid + ", companyname=" + companyname + ", ledgername="
				+ ledgername + ", transactionvalue=" + transactionvalue + ", creatdate=" + creatdate + "]";
	}
	
	
}