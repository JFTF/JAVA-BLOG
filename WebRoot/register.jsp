<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	
	</style>
          <link href="css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script src="js/bootstrap/jquery.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/leYou/user.js"></script>
    <script type="text/javascript">
     function register(){
     var user = new User();
      
      if(user.getRegister() == "用户输入格式合法")
        return true;
        else{
          
         alert(user.getRegister());
          return false;
      
        }
     }
    </script>
  </head>
  
  <body>
  <h1 style="text-align: center">用户信息注册</h1>
  <br><br>
    <form class="form-horizontal" name="myForm" action="/leyou/myself/register"  role="form">
  <div class="form-group">
    <label  class="col-sm-5 control-label">用户名</label>
    <div class="col-sm-7">
      <div class="col-sm-4">
         <input type="text" id="nickName"  name="nickName"  class="form-control"  placeholder="Name" />
     </div>
    </div>
  </div>
  <div class="form-group">
    <label  class="col-sm-5 control-label">密码</label>
    <div class="col-sm-7">
       <div class="col-sm-4">
         <input type="password" id="password" name="password" class="form-control"  placeholder="Password" />
       </div>
    </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-5 control-label">真实姓名</label>
    <div class="col-sm-7">
      <div class="col-sm-4">
         <input type="text" id="name"  name="name"  class="form-control"  placeholder="Name" />
     </div>
    </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-5 control-label">性别</label>
    <div class="col-sm-7">
      <div class="col-sm-4">
         男：<input type="radio"  name="sex" value="男"  placeholder="Sex" />   
         女 ：<input type="radio"  name="sex" value="女" placeholder="Sex" />
       
     </div>
    </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-5 control-label">所在院校或单位</label>
    <div class="col-sm-7">
      <div class="col-sm-4">
         <input type="text" id="graduate"  name="graduate"  class="form-control"  placeholder="Graduate" />
     </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-6">
      <button type="button" class="btn btn-default"  onclick="if(register()!=false)document.myForm.submit();">注册</button>
    </div>
  </div>
</form>
  </body>
</html>
