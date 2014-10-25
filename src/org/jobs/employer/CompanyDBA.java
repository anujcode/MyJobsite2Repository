package org.jobs.employer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jobs.CandidateProfile;
import com.jobs.User;

public class CompanyDBA {
	
	
	public boolean registerCompany(Company company){
		
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
	

	public boolean checkCompany(Company company,Session session){
	
	
		String hql = "from Company comp where comp.companyName = :name";
		
		Query q = session.createQuery(hql);
		q.setString("name", company.getCompanyName());
		Company comp = (Company) q.uniqueResult();
		
		
		//username match found
		if(comp!=null){
				
			return true;
					
		}
		
		return false;
	
	
	}


	
	
	public boolean authenticateCompany(Company company){
		
		Boolean validCompany = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		validCompany = authorize(company,session);
		
		if(!validCompany){
			
			
			return false;
			
		}
		
		return true;
		
		
	}
	
	
	
	public boolean authorize(Company company,Session session){
		
		
		String hql = "from Company comp where comp.companyName = :name and comp.password = :pwd";
		
		Query q = session.createQuery(hql);
		
		q.setString("name", company.getCompanyName());
		q.setString("pwd", company.getPassword());
		
		Company comp = (Company) q.uniqueResult();
		
		
		//username match found
		if(comp!=null){
				
			return true;
					
		}
		
		return false;
		
	}
	
	
	
	
	public void saveCompanyProfile(CompanyProfile profile){
		
		//Boolean candidateExists = true;
		
		//CompanyProfile tempprofile = null;
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String name = profile.getName();
		//System.out.println(user.getUserid());
		String hqprof = "from Company comp where comp.companyName = :name1";
		Query qprof = session.createQuery(hqprof);
		
		qprof.setString("name1", name);
		Company comp = (Company)qprof.uniqueResult();
		System.out.println("Company id of Company saved in company_registration table" + comp.getCompanyID());
		
		//System.out.println(user.getUsername());
		profile.setCompany(comp);
		
		//candidateExists = checkUsername(user,session);
		
		//if(!candidateExists){
		//profile = (CompanyProfile) session.get(CompanyProfile.class, profile.getProfileID());
			
				
				session.merge(profile);
				session.getTransaction().commit();
				session.close();
			
			//return false;
			
		//}
		
		//return true;
		
		
	}
	
	
	
	public boolean saveJob(JobBean job){
		
		Boolean jobExists = true;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		jobExists = checkJob(job,session);
		
		if(!jobExists){
			
			session.save(job);
			session.getTransaction().commit();
			session.close();
			return false;
			
		}
		
		return true;
		
		
	}
	
	
	
	public boolean checkJob(JobBean job,Session session){
		
		
		String hql = "from JobBean job where job.company = :jcomp and job.title = :jobtitle";
		
		Query q = session.createQuery(hql);
		q.setString("jcomp", job.getCompany());
		q.setString("jobtitle",job.getTitle());
		
		JobBean jobObj = (JobBean) q.uniqueResult();
		
		
		//username match found
		if(jobObj!=null){
				
			return true;
					
		}
		
		return false;
	
	
	}
	
	





//end of class
}
