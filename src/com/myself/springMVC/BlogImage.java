package com.myself.springMVC;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/blog/image/*")
public class BlogImage {
	@RequestMapping("head")
    public  void head(HttpServletRequest request,HttpServletResponse response ){
		HttpSession session = request.getSession();
		CommonsMultipartResolver multipartResolver  = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			
			Iterator<String>  iter = multiRequest.getFileNames();
			while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile((String)iter.next());
				if(file != null){
					System.out.println(file.getContentType());
			
					String fileName ="1.png";
					String directory= "D:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\leyou\\img\\user\\"+session.getAttribute("nickName").toString();
					File mkdirPath =new File(directory);    
					//如果文件夹不存在则创建    
					if  (!mkdirPath.exists()  && !mkdirPath.isDirectory())      
                         mkdirPath.mkdir();    
			
		        	String path = directory +"\\"+ fileName;
					File localFile = new File(path);
					
					try {
						file.transferTo(localFile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		  }
       }
}
