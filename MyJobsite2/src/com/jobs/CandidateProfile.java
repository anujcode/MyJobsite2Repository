package com.jobs;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="c_profile")
public class CandidateProfile {
	
	
	
	
	
	public CandidateProfile(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CANDIDATEID")
	private int candidateID;
	
	@OneToOne
	@JoinColumn(name="USERID")
	private User user;
	
	
	@Column(name="CANDIDATENAME")
	private String name;
	
	@Column(name="CANDIDATEPHONE")
	private String phone;
	
	@Column(name="CANDIDATEEMAIL")
	private String email;
	
	

	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
