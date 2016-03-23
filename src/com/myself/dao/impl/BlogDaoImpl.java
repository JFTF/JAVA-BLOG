package com.myself.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;






import com.myself.dao.BlogDao;
import com.myself.model.Blog;
import com.myself.model.BlogAll;
import com.myself.model.BlogInfo;

@Component("blogDaoImpl")
public class BlogDaoImpl implements BlogDao{
	
	private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 
	
	public boolean saveOrUpdate(Blog blog,String nickName) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Query q= session.createQuery("from Blog blog where blog.title = ? and nickName = ?  ");
		    q.setParameter(0, blog.getTitle());
		    q.setParameter(1, nickName);
		   
		 if(q.list().size()>0){
		Query q1=  session.createQuery("update Blog blog set blog.category = ?,blog.content = ? where blog.title = ? and nickName = ?");
		
		  q1.setParameter(0, blog.getCategory());
		  q1.setParameter(1, blog.getContent());
		  q1.setParameter(2, blog.getTitle());
		  q1.setParameter(3, nickName);
		  q1.executeUpdate();
		 }
		 else
			 session.save(blog);
		  session.getTransaction().commit();
		return true; 
   }
	
   
	public List<Blog> query(Blog blog) {
		// TODO Auto-generated method stub
		
	  return null;
	}
	/**
	public List<BlogAll> query(){
		// TODO Auto-generated method stub
		 Session session=sessionFactory.getCurrentSession();
		 session.beginTransaction();
	     Query query= session.createQuery("from Blog blog,BlogInfo blogInfo where blog.blog = blogInfo.nickName" );
	     List<Object> list = query.list();
	     Iterator iter = list.iterator();
	     List<BlogAll> list1 = new ArrayList<BlogAll>();
	    
		  while(iter.hasNext()){
			  BlogAll blogAll = new BlogAll();
			   Object[] object = (Object[])iter.next();
			   Blog  blog = (Blog)object[0];
			   blogAll.setCategory(blog.getCategory());
			   blogAll.setContent(blog.getContent());
			   blogAll.setTitle(blog.getTitle());
			   blogAll.setId(blog.getId());
			   BlogInfo blogInfo = (BlogInfo)object[1];
			   blogAll.setTell(blogInfo.getEducation());
			   blogAll.setEducation(blogInfo.getEducation());
			   blogAll.setInterest(blogInfo.getInterest());
			   blogAll.setNickName(blogInfo.getNickName());
			
			  
			   list1.add(blogAll);
		  }
	   
        session.getTransaction().commit();
		return  list1;
	}
     public BlogAll query(int id){
    	   Session session=sessionFactory.getCurrentSession();
 		  session.beginTransaction();
 	     Query query= session.createQuery("from Blog blog,BlogInfo blogInfo where blog.blog = blogInfo.nickName and blog.id = ?");
 	     query.setParameter(0,id);
 	    List<Object> list = query.list();
	     Iterator iter = list.iterator();
	     BlogAll  blogAll = new BlogAll();
		  while(iter.hasNext()){
			
			   Object[] object = (Object[])iter.next();
			   Blog  blog = (Blog)object[0];
			   blogAll.setCategory(blog.getCategory());
			   blogAll.setContent(blog.getContent());
			   blogAll.setTitle(blog.getTitle());
			   blogAll.setId(blog.getId());
			   BlogInfo blogInfo = (BlogInfo)object[1];
			   blogAll.setTell(blogInfo.getEducation());
			   blogAll.setEducation(blogInfo.getEducation());
			   blogAll.setInterest(blogInfo.getInterest());
			   blogAll.setNickName(blogInfo.getNickName());
			 
		  }
	   
         session.getTransaction().commit();
		 return  blogAll;
		}
*/
	public List<Blog> query(String nickName, String title) {
	
		 Session session=sessionFactory.getCurrentSession();
		  session.beginTransaction();
		 Query q= session.createQuery("from Blog blog where blog.title = ? and nickName = ? ");
		    q.setParameter(0,title);
		    q.setParameter(1,nickName);
		
		  List<Blog>   list= q.list();
		 
         session.getTransaction().commit();
		return  list;
	}

	public List<BlogAll> query() {
		// TODO Auto-generated method stub
		return null;
	}

	public BlogAll query(int id) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
