<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showlog.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

   <link href="css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script src="js/bootstrap/jquery.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/json2.js"></script>
  
  
    
  </head>
  
  <body>

 <div id="formbackground" style="position:absolute; width:100%; height:100%; z-index:-1">  
    <img src="img/blog/5af6135671a68f3e23952ccfd59d5ec4.gif" height="100%" width="100%"/>  
 </body>
</html>
