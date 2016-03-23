package com.myself.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.MessageDigest;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.myself.dao.UserDao;
import com.myself.model.user.UserInfo;
import com.myself.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	@Resource(name="userDaoImpl")
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    //登录
	public String firm(UserInfo userInfo,HttpServletRequest request,String firmCode) {
	  HttpSession session =	request.getSession();
	  String randomString ;
	 try{
  	    randomString = session.getAttribute("RandomString").toString();
  	  
	 }catch(Exception e){
		 randomString = "";
	 }
  	  if(randomString.equals("") || randomString.equalsIgnoreCase(firmCode) ){
  		session.setAttribute("RandomString", getRandomString());
  		if(userInfo.getNickName().equals(""))
  		  return "帐号不能为空";
  	    else if(userInfo.getPassword().equals(""))
  		  return "密码不能为空"; 
  	    else if(userInfo.getNickName().length()>15)
  		  return "帐号过长";
  	    else if(userInfo.getPassword().length()>20)
  		  return  "密码过长";
  	    else{
  		  String password = MD5(userInfo.getPassword());
  	      userInfo.setPassword(password);
  		  if(userDao.find(userInfo))
  		  {
  			  session.setAttribute("loginFirm", "success");
  		      return "OK";
  		  }
  		  else
  		  return "用户名或密码不正确";
  	    }
  	  }
  	  else
  		 return "登录失败";
	  
	}
	
	
	
	//注册
	public String register(UserInfo userInfo){
		  if(userInfo.getNickName().equals(""))
			  return "帐号不能为空";
		  else if(userInfo.getPassword().equals(""))
			  return "密码不能为空"; 
		  else if(userInfo.getNickName().length()>15)
			  return "帐号过长";
		  else if(userInfo.getPassword().length()>20)
			  return  "密码过长";
		  else{
			  String password = MD5(userInfo.getPassword());
		      userInfo.setPassword(password);
		
			  if(userDao.save(userInfo))
			  return "OK";
			  else
			  return "用户名以被使用";
			  
		  }
	  }
	  //加密
	  public final static String MD5(String s) {
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
	        try {
	            byte[] btInput = s.getBytes();
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要
	            mdInst.update(btInput);
	            // 获得密文
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    //验证码
	    public static final char[] CHARS = {
	    	'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N',
	    	'P','Q','R','S','T','U','V','W','X','V','Z'
	    };
	    public static String getRandomString(){
	         
	    	StringBuffer  buffer = new StringBuffer();
	        for( int i=0;i<6;i++)
	        	buffer.append(CHARS[random.nextInt(CHARS.length)]);
	        return buffer.toString();
	    }
	    public static Random  random = new Random();
	  
	    public static Color getRandomColor(){
	    	return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	    }
	    public static Color getReverseColor(Color c){
	    	return new Color(255-c.getRed(),255-c.getGreen(),255 -c.getBlue());
	    }
	    public BufferedImage getRandomImage(HttpServletRequest request){
	    	 int height =  30;
	    	 int width  = 100;
	    	 String randomString = getRandomString();
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("RandomString", randomString);
	    	 Color  color = getRandomColor();
	    	 Color  reverse = getReverseColor(color);
	    	 BufferedImage  bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	    	 Graphics2D g = bi.createGraphics();
	    	 g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
	    	 g.setColor(color);
	    	 g.fillRect(0, 0, width, height);
	    	 g.setColor(reverse);
	    	 g.drawString(randomString, 18, 20);
	    	 for(int i=0; i <  100 ; i++){
	    		 g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
	    	 }
	    	 return bi;
	    }
}
