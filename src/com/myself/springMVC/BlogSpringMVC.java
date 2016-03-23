package com.myself.springMVC;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;

import com.myself.dao.impl.BlogDaoImpl;
import com.myself.model.Blog;
import com.myself.model.BlogAll;
import com.myself.model.BlogInfo;
import com.myself.model.user.UserInfo;


@Controller
@RequestMapping("/blog/*")
public class BlogSpringMVC {
    private BlogDaoImpl blogDaoImpl;
	
	@Resource(name="blogDaoImpl")
	public void setBlogDaoImpl(BlogDaoImpl blogDaoImpl) {
		this.blogDaoImpl = blogDaoImpl;
	}
	@RequestMapping("edit")
    public void logEdit(Blog blog,HttpServletRequest res,HttpServletResponse rep){
		HttpSession session = res.getSession();
		
		UserInfo user =(UserInfo) session.getAttribute("user");
	    blog.setUser(user);
	    this.blogDaoImpl.saveOrUpdate(blog,user.getNickName());
		    
	 }
	
	 @RequestMapping("find")
	 public void findBlog(HttpServletResponse res){
		
		List<BlogAll> list=this.blogDaoImpl.query();
		  JSONArray jsons = new JSONArray(); 
		  for(int j=0;j<list.size();j++){  
	            JSONObject jsonObject = new JSONObject();  
	            jsonObject.put("blogInfo", list.get(j));  
	            jsons.add(jsonObject);  
	        }  
		 try {
		
	     res.getWriter().print(new String(jsons.toString().getBytes("utf-8"),"ISO-8859-1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 @RequestMapping("BlogId")
     public void blogId(int id,HttpServletResponse res){
	
		  BlogAll blogAll= this.blogDaoImpl.query(id);
		
		
	            JSONObject jsonObject = new JSONObject();  
	            jsonObject.put("blogAll",blogAll);  
	           
	          
		 try {
	 
		
			res.getWriter().print(new String( jsonObject.toString().getBytes("utf-8"),"ISO-8859-1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 @RequestMapping("updateBlog")
	 @ResponseBody
     public void updateBlog(String title,HttpServletResponse res,HttpServletRequest req){
		 HttpSession session = req.getSession();
		 UserInfo userInfo =(UserInfo) session.getAttribute("UserInfo");

		 List<Blog>  list=this.blogDaoImpl.query(userInfo.getNickName(), title);
		 System.out.println(list.size());
		    Blog  blog = (Blog)list.get(0);
		    JSONObject jsonObject = new JSONObject();  
            jsonObject.put("blog",blog);  
		 try {
	      res.getWriter().print(new String(jsonObject.toString().getBytes("utf-8"),"ISO-8859-1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	
	 @RequestMapping("editing")
     public String logEditing(String username){
		return "WEB-INF/blogContent";
	 }
}
