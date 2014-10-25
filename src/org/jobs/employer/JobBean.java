package org.jobs.employer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="jobs_created")
public class JobBean {

	
	public JobBean(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="JobID")
	private int jobID;

	@Column(name="Jobtitle")
	private String title;
	
	@Column(name="Company")
	private String company;
	
	
	@Column(name="Location")
	private String location;

	
	@Column(name="Creation_Date")
	private String date;
	
	
	
	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	
	
}
