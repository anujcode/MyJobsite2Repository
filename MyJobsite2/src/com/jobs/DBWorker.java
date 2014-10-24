package com.jobs;

//import javax.persistence.Query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBWorker {
	
	
	
	
	public void saveCandidateProfile(CandidateProfile cprofile){
		
		//Boolean candidateExists = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String name = cprofile.getName();
		System.out.println(user.getUserid());
		String hqprof = "from User cd where cd.username = :name1";
		Query qprof = session.createQuery(hqprof);
		
		qprof.setString("name1", name);
		User cd = (User)qprof.uniqueResult();
		System.out.println("User id of user saved in registration table" + cd.getUserid());
		
		//System.out.println(user.getUsername());
		cprofile.setUser(cd);
		
		//candidateExists = checkUsername(user,session);
		
		//if(!candidateExists){
			
			session.save(cprofile);
			session.getTransaction().commit();
			session.close();
			//return false;
			
		//}
		
		//return true;
		
		
	}
	
	
	
	public boolean registerUser(User user){
		
		Boolean userExists = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		userExists = checkUsername(user,session);
		
		if(!userExists){
			
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return false;
			
		}
		
		return true;
		
		
	}
	
	
	public boolean checkUsername(User user,Session session){
		
		
		String hql = "from User cid where cid.username = :name";
		
		Query q = session.createQuery(hql);
		q.setString("name", user.getUsername());
		User cdate = (User) q.uniqueResult();
		
		
		//username match found
		if(cdate!=null){
				
			return true;
					
		}
		
		return false;
		
	}
	
	
	
	
	
	
	public boolean authenticateUser(User user){
		
		Boolean validUser = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		validUser = authenticate(user,session);
		
		if(!validUser){
			
			
			return false;
			
		}
		
		return true;
		
		
	}
	
	
	public boolean authenticate(User user,Session session){
		
		
		String hql = "from User cd where cd.username = :name and cd.password = :pwd";
		
		Query q = session.createQuery(hql);
		
		q.setString("name", user.getUsername());
		q.setString("pwd", user.getPassword());
		
		User cdate = (User) q.uniqueResult();
		
		
		//username match found
		if(cdate!=null){
				
			return true;
					
		}
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	/*public Boolean saveCompany(CompanyDetails company){
		
		Boolean companyExists = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		companyExists = checkCompany(company,session);
		
		if(!companyExists){
			
			session.save(company);
			session.getTransaction().commit();
			session.close();
			return false;
			
		}
		
		return true;
		
		
	}
	
	*/
	
	
	
	public void saveJob(JobPosting posting){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		session.save(posting);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	
	
	/*public Boolean checkCompany(CompanyDetails company,Session session){
		
		
		String hql = "from CompanyDetails c where c.company = :cname";
		
		Query q = session.createQuery(hql);
		q.setString("cname", company.getCompany());
		company = (CompanyDetails) q.uniqueResult();
		
		
		//if username match found
		if(company!=null){
				
			return true;
					
		}
		
		return false;
		
	}*/
	
	
	
	
	
	
	
	
	
	
	

}
