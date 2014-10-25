package com.jobs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="jobs_posted")
public class JobPosting {

	
	public JobPosting()
	{
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JobID")
	private int jobid;
	
	@Column(name="Company")
	private String company;
	
	@Column(name="JobTitle")
	private String title;
	
	@Column(name="Location")
	private String location;

	
	
	
	
	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	



}
