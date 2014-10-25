package org.jobs.employer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="company_profile")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)

public class CompanyProfile {

	public CompanyProfile(){}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ProfileID")
	private int profileID;
	
	@OneToOne
	@JoinColumn(name="companyID")
	private Company company;
	
	
	@Column(name="CompanyName")
	private String name;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Website")
	private String website;

	
	
	
	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
}
