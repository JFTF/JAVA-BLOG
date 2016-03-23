package com.myself.dao.impl;



import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.myself.dao.UserDao;
import com.myself.model.user.UserInfo;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;

    @Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean find(UserInfo userInfo) {
		
    Session session=sessionFactory.getCurrentSession();
    session.beginTransaction();
    try{
    UserInfo u= (UserInfo) session.get(UserInfo.class,userInfo.getNickName());
    session.getTransaction().commit();
    if(u.getPassword().equals(userInfo.getPassword()))
    	  return true;
    else 
          return false;
	
	}catch(Exception e){
		return false;
	}}
	public boolean save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		 
		 Session session=sessionFactory.getCurrentSession();
		 try{
		 session.beginTransaction();
		 
		
		 session.save(userInfo);
		
         session.getTransaction().commit(); 
		 }catch(Exception e){
			 return false;
		 }
             return true;
		
		
	}
	
}
