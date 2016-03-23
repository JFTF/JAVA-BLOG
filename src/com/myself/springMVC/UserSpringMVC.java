package com.myself.springMVC;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

















import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leyou.weather.WeatherClient;
import com.myself.model.user.UserInfo;
import com.myself.service.UserService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


@Controller
@RequestMapping("/myself/*")
public class UserSpringMVC{
	private UserService userService;
    @Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

 
	@RequestMapping("login")
    public String login(UserInfo userInfo,String firmCode,HttpServletResponse res,HttpServletRequest req) {
	res.setContentType("image/jpeg");
	HttpSession  session = req.getSession();
	
	String success ="";
	try{
	 success =	session.getAttribute("loginFirm").toString();
	 if(success.equals("success")){isFile(res, req);
		  return "/WEB-INF/MySelfHome";}
	 }
	catch(Exception e){}
	try{
	String error = req.getParameter("error");
	if(error.equals("false"))
		 return "redirect:/index.jsp?error=false";
	}
	catch(Exception e){}

    String msg = userService.firm(userInfo,req,firmCode);
	if(msg.equals("OK")){
	    session.setAttribute("nickName",userInfo.getNickName());
	    isFile(res, req);
	   	return  "/WEB-INF/MySelfHome";}
	else{  
		  session.setAttribute("error", "true");
		  return "redirect:/index.jsp?error=true";
	    }
    }
	
	public void isFile(HttpServletResponse res,HttpServletRequest req){
	   HttpSession session = req.getSession();
       String directory= 
       "D:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\leyou\\img\\user\\"
       +session.getAttribute("nickName").toString();
		File mkdirPath =new File(directory);    
		//如果文件夹不存在则创建    
		
		if  (!mkdirPath.exists()  && !mkdirPath.isDirectory()) 
		{       int bytesum = 0;   
		  int byteread = 0;  
             mkdirPath.mkdir(); 
             try{
             File oldfile = new File("C:\\Users\\jian\\Downloads\\1.jpg");   
             if (oldfile.exists()) {   
            	 System.out.println("ddddddddddddddddddddddddddd");
             InputStream inStream = new FileInputStream("C:\\Users\\jian\\Downloads\\1.jpg");   
             FileOutputStream fs = new FileOutputStream(directory+"\\1.png");   
             byte[] buffer = new byte[1444];   
             int length;   
             while ( (byteread = inStream.read(buffer)) != -1) {   
             bytesum += byteread;   
             System.out.println(bytesum);   
             fs.write(buffer, 0, byteread);   
             }   
             inStream.close();   
             } 
             }catch(Exception e){}
             }   
             
	}
	@RequestMapping("exit")
    public String exit(HttpServletResponse res,HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("loginFirm", "");
		return "redirect:/index.jsp";
		
	}
	@RequestMapping("weatherLocal")
	public void weatherLocal(String city,HttpServletResponse res) throws UnsupportedEncodingException{
		WeatherClient weather = new WeatherClient();
	    List<String> list=	weather.weather(city);
	    Map<String,String> map = new HashMap<String,String>();
		map.put("city",list.get(1));
		map.put("weather",list.get(10));
		map.put("cladIndex",list.get(11));
	    PrintWriter print =null;
		try {
			print = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(map); 
		System.out.println(new String(json.toString().getBytes("utf-8"),"ISO-8859-1"));
	    print.println(new String(json.toString().getBytes("utf-8"),"ISO-8859-1"));
	    
	}
	@RequestMapping("isLogin")
    public void isLogin(HttpServletResponse res,HttpServletRequest req) {
		PrintWriter print =null;
		try {
			print = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	HttpSession  session = req.getSession(false);
	if(session == null)
		 print.print("false");
	else{
	
	String success ="";
	try{
	 success =	session.getAttribute("loginFirm").toString();
	 if(success.equals("success"))
		 print.print("true");
	 else
			 print.print("false");
	}
	catch(Exception e){
		 print.print("false");
	}
	
	}
 
    }
	@RequestMapping("image")
	public void pictrue(HttpServletResponse res,HttpServletRequest req){
		  res.setContentType("image/jpeg");
	      BufferedImage  bi = userService.getRandomImage(req);
	      ServletOutputStream  out=null;
	   	 try{
			out = res.getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(bi);
		
			out.flush();
			out.close();
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@RequestMapping("register")
    public String query(@ModelAttribute UserInfo userInfo,HttpServletRequest req){
	
	      Date time = new Date();
	   
	       userInfo.setRegisterDate(time);
		  String msg = userService.register(userInfo);
		
		  if(msg.equals("OK")){
			   req.setAttribute("nickName",userInfo.getNickName());
	           return "/WEB-INF/MySelfHome";
		   }
		   else
		   return "/register";
     }
  
	
}

