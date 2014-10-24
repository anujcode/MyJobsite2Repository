package org.jobs.employer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="company_reg")
public class Company {

	
	public Company(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="companyID") 
	private int companyID;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="password")
	private String password;
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
