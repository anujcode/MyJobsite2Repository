package org.jobs.employer;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobs.CandidateProfile;
import com.jobs.DBWorker;


@Path("/company")
public class CompanyService {

	
	@POST
	@Path("/register")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean register(InputStream ip) {
 
		Boolean companyExists = true;
		Company company = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			company = mapper.readValue(ip, org.jobs.employer.Company.class);
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CompanyDBA compDBA = new CompanyDBA();
		companyExists = compDBA.registerCompany(company);
		
		if(companyExists){
			
			System.out.println(company.getCompanyID());
			System.out.println(company.getCompanyName());
			System.out.println("Company exists. Please enter a different company!");
			return true;
			
		}
		
		
		return false;
		
		
	}
	
	
	@POST
	@Path("/login")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean login(InputStream ip) {
 
		Boolean validCompany = true;
		Company company = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			company = mapper.readValue(ip, org.jobs.employer.Company.class);
			//System.out.println(company.getCompanyName());
			//System.out.println(company.getCompanyID());

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CompanyDBA compDBA = new CompanyDBA();
		validCompany = compDBA.authenticateCompany(company);
		
		
		if(!validCompany){
			
			//System.out.println(company.getCompanyID());
			//System.out.println(user.getPassword());
			//System.out.println("Invalid Candidate. Please check login details");
			return false;
			
		}
		
		
		return true;
		
		
	}
	
	
	
	
	@POST
	@Path("/profile")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean registerProfile(InputStream ip) {
 
		//Boolean candidateExists = true;
		CompanyProfile profile = null;
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			
			profile = mapper.readValue(ip, org.jobs.employer.CompanyProfile.class);
		
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(profile.getName());
		System.out.println(profile.getProfileID());
	
		
		CompanyDBA compDBA = new CompanyDBA();
		compDBA.saveCompanyProfile(profile);
		
		
		
		return true;
		
		
	}
	
	
	@POST
	@Path("/createjob")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean createJob(InputStream ip) {
 
		Boolean jobExists = true;
		JobBean job = null;
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			
			job = mapper.readValue(ip, org.jobs.employer.JobBean.class);
		
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(profile.getName());
		System.out.println(job.getCompany());
	
		
		CompanyDBA compDBA = new CompanyDBA();
		jobExists = compDBA.saveJob(job);
		
		if(jobExists){
			
			System.out.println(job.getCompany());
			System.out.println("Job already exists. Please enter a different job!");
			return false;
			
		}
		
		
		return true;
		
		
	}
	
	
	
	
	
	
}
