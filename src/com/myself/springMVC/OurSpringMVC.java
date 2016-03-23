package com.myself.springMVC;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myself.dao.impl.BlogInfoDaoImpl;
import com.myself.model.BlogInfo;

@Controller
@RequestMapping("/ourself/*")
public class OurSpringMVC {
	
    private BlogInfoDaoImpl blogInfoDaoImpl;
	
	@Resource(name="blogInfoDaoImpl")
	public void setBlogInfoDaoImpl(BlogInfoDaoImpl blogInfoDaoImpl) {
		this.blogInfoDaoImpl = blogInfoDaoImpl;
	}
  
   @RequestMapping("blogInfo")
   public void  blogInfo(BlogInfo blogInfo,HttpServletResponse rep,HttpServletRequest res){
	   PrintWriter print=null;
	try {
		print = rep.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
	    e.printStackTrace();
	}  
	HttpSession session = res.getSession();
	BlogInfo blogInfo1 =(BlogInfo) session.getAttribute("blogInfo");
	blogInfo.setNickName(blogInfo1.getBlog());
	String success = "操作成功";
	String error = "操作失败";
	String  result1 ="";
	String  result2 ="";
	try {
		 result1=new String(success.getBytes("utf-8"),"ISO-8859-1");
		 result2=new String(error.getBytes("utf-8"),"ISO-8859-1");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(blogInfoDaoImpl.update(blogInfo))
	   {   
		   print.println(result1);
	   }
	   else
		   print.println(result2);
   }
 
}
