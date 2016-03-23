package com.myself.dao.impl;



import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import com.myself.dao.BlogInfoDao;

import com.myself.model.BlogInfo;

@Component("blogInfoDaoImpl")
public class BlogInfoDaoImpl implements BlogInfoDao {
private SessionFactory sessionFactory;
	

    @Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean update(BlogInfo blogInfo) {
		// TODO Auto-generated method stub
	
		 StringBuffer hql = new StringBuffer();
		 hql.append("update BlogInfo blogInfo set");
		 hql.append("blogInfo.tell = ?,blogInfo.education = ?,blogInfo.interest = ?");
		 hql.append("where blogInfo.nickName = ?");
		  Session session=sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  try{
			  Query query=session.createQuery("update BlogInfo blogInfo set blogInfo.tell = ?,blogInfo.education = ?,blogInfo.interest = ? where blogInfo.nickName = ?");
			  query.setParameter(0,blogInfo.getTell());
			  query.setParameter(1,blogInfo.getEducation());
			  query.setParameter(2,blogInfo.getInterest());
			  query.setParameter(3,blogInfo.getNickName());
			  query.executeUpdate();
	    	  session.getTransaction().commit();
			  return true;
		  }catch(Exception e){
			
		     return false;
		  }
         
         
	}

	public BlogInfo find(BlogInfo blogInfo) {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  try{
			  BlogInfo blog = (BlogInfo)session.load(BlogInfo.class,blogInfo.getNickName());
          session.getTransaction().commit(); 
           return  blog;
		  }catch(Exception e){
			  return null;
		  }
		
	}

	public boolean save(BlogInfo blogInfo) {
		// TODO Auto-generated method stub
		 
		 Session session=sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 try{
		 session.save(blogInfo);
         session.getTransaction().commit(); 
             return true;
		 }catch(Exception e){
			 return false;
		 }
		
	}

	public boolean firm(BlogInfo blogInfo) {
		 Session session=sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 try{
	     BlogInfo blog=( BlogInfo)session.get(BlogInfo.class,blogInfo.getNickName());
         session.getTransaction().commit(); 
         if( blog.getPassword().equals(blogInfo.getPassword()))
             return true;
		 }catch(Exception e){
			 return false;
		 }
		return false;
	} 
	
}
