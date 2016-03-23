<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyLog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/json2.js"></script>
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="js/amazrui.js"></script>
    <link rel="stylesheet" type="text/css" href="css/amazeui.css">
    <style type="text/css">
       .div_body{margin-left:200px; margin-top:30px;}
       .edit_content_div{width:700px; }
    </style>
    <script type="text/javascript">
   function GetRequest() {
  
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
    }
    var Request = new Object();
        Request = GetRequest();
        var nickName =  Request["nickName"];
        
       function message(){
       
       var title = document.getElementById("title").value;
       var content = CKEDITOR.instances['content'].getData();
       var category = document.getElementById("category").value;
       var blog =  {title:title,content:content,category:category};
       $.ajax({
         type:"post",
         url:"/Dream/blog/edit",
         data:blog,
         success:function(data){
             alert("success");
         },
         error:function(data){
            alert("error");
         },
        
       });
       }
       
       function updateBlog(){
        var title = document.getElementById("title").value;
           $.ajax({
            type:'post',
            data:{title:title},
            url:'/Dream/blog/updateBlog',
            async: false,
            success:function(data){
            var JSONUpdate= JSON.parse(data);
            alert(JSONUpdate.blog.content);
             CKEDITOR.instances['content'].setData(JSONUpdate.blog.content);
            },
            error:function(data){
              alert("error");
            }
           
           });
       }
       
       
       
     </script>
  </head>

  <body>
       <div>
           <h1 align="center"> 个人博客编辑</h1>
        </div>
      <div class="div_body">
       
       <span><label class="log_topic">标题</label>
       <input type="text" style="width:300px" id="title" name="title">
            <button type="button" onclick="updateBlog()">修改</button> 
         
       </span>
       <br><br>
       
       <span><label class="log_topic">类型</label> 
       <select id="category" style="width:70px;">
          <option  value="java">java</option>
          <option  value="linux">linux</option>
          <option  value="net">net</option>
          <option  value="php">php</option>
       </select>
       </span>
       <br><br>
       <div class="edit_content_div">   
       <label class="log_content">编辑博客内容</label><br>
       <textarea cols="60" id="content" name="content" rows="10">
       </textarea>
        <script>
            CKEDITOR.replace( 'content' );
        </script>
         <br><br>
        <button type="button" class="am-btn am-btn-primary am-round" onclick="message()">提交博客</button>
      
        </div>
    </div>
     
    
  </body>
</html>
