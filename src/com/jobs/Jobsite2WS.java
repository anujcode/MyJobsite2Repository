package com.jobs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;






import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@Path("/service")
public class Jobsite2WS {
	
	//private Candidate candidate_global = new Candidate();
	/*
	@GET
	@Path("/jobsearch")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResults(){
		
		
		//ObjectMapper mapper = new ObjectMapper();
		//OutputStream out = null;
		
		DBWorker dba = new DBWorker();
		
		//String username = dba.dbResults();
		System.out.println(username);
		
		
		//String result = "User"+ user;
		
		//String output = dba.dbResults();
		//String result="Hello "+name;
		//System.out.println(result);
		//return result;
		//return output;
		return username;
	}
	
	*/
	
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean registerUser(InputStream ip) {
 
		Boolean userExists = true;
		User user = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			user = mapper.readValue(ip, com.jobs.User.class);
		
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
		
		DBWorker dba = new DBWorker();
		userExists = dba.registerUser(user);
		
		if(userExists){
			
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("User exists. Please enter a different username!");
			return true;
			
		}
		
		
		return false;
	
		
	}
	
	
	
	@POST
	@Path("/login")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean loginForm(InputStream ip) {
 
		Boolean validCandidate = true;
		User user = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			user = mapper.readValue(ip, com.jobs.User.class);
			System.out.println(user.getUsername());
			
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
		
		DBWorker dba = new DBWorker();
		validCandidate = dba.authenticateUser(user);
		
		if(!validCandidate){
			
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("Invalid Candidate. Please check login details");
			return false;
			
		}
		
		
		return true;
		
		
	}
	
	
	@POST
	@Path("/cprofile")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean registerProfile(InputStream ip) {
 
		//Boolean candidateExists = true;
		CandidateProfile cprofile = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			cprofile = mapper.readValue(ip, com.jobs.CandidateProfile.class);
		
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
		
		//System.out.println(cprofile.getEmail());
		//System.out.println(cprofile.getPhone());
		//System.out.println("In cprofile webmethod " + candidate_global.getUsername());
		
		DBWorker dba = new DBWorker();
		dba.saveCandidateProfile(cprofile);
		//candidateExists=dba.registerCandidate(cprofile);
		
		//if(candidateExists){
			
			
			
			//return true;
			
		//}
		
		
		return true;
		
		
	}
	
	
	
	/*@RequestMapping(value = "/jobform", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String echoName(Person person) {
 
		String result = "Person recvd : " + person;
		System.out.println(result);
		System.out.println(person.getUsername());
		System.out.println(person.getPassword());
		return result;
 
	}
	
	*/
}
