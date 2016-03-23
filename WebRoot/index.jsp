<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>贝贝之家</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
       <link href="css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script src="js/bootstrap/jquery.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/leYou/user.js"></script>
    <script type="text/javascript" src="js/json2.js"></script>
    <style>
        .progress{
            padding: 0px;
            margin: 0px;
        }
        .navbar{
            padding: 0px;
            margin: 0px;
        }
        h1{
            float: left;
        }
        #img2{
           float: left;
        }
        .h2{
           color: red;
        }
      
    </style>
  
   
    <script type="text/javascript">
 
        var error= "";
        var data="";
        var data1="";
       var li = "";
       var loginFirm="";
       $(function(){  
       $.ajax({
        type:"post",
        url:"/leyou/myself/isLogin",
        success:function(data){
       
          this.data = data;
         
       },
       complete:function(data){
          if(this.data == "false"){
            document.getElementById("loginOrExit").innerHTML="登录";
         //   document.getElementById("loginOrExit").onclick = checkLogin();
     
        document.getElementById("loginOrExit").onmouseover = function(){
        
              document.getElementById("loginOrExit").href="/leyou/myself/login?error=false";
                 }; }; 
          if(this.data == "true"){
               var li=document.createElement("li");
               var a = document.createElement("a");
               var  ul= document.getElementById("rightUl");
            
                a.innerHTML="我的主页";
               a.href="/leyou/myself/login";
               li.appendChild(a);
               ul.appendChild(li);
               document.getElementById("loginOrExit").innerHTML="退出";
               document.getElementById("loginOrExit").href="/leyou/myself/exit";
          }
       }
      });
       
       error="<%=request.getParameter("error")%>";
          if(error == "true")
           {
             document.getElementById("error").innerHTML="用户名或密码错误！";
             $('#myModal').modal({
                keyboard: false
             });
           }
             if(error == "false")
           {
           
             $('#myModal').modal({
                keyboard: false
             });
           }
            document.getElementById("identity1").src = "/leyou/myself/image";
          });
            function reloadImage(){
               
               document.getElementById("identity1").src = "/leyou/myself/image";
           }
            
            </script>
  </head>
  
  <body>
   
    <div  class="head" style="background-color: white; height:50px;  width: 100%">
     
    </div>

    <nav class="navbar navbar-inverse" style="font-family: '微软雅黑';" >
        <div class="container" id="center">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img alt="Brand" src="img/index/1.png">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                   
                    <li><a href="/leyou/ourself/login">博客</a></li>
                    <li><a>购物持家</a></li>
                    <li><a>信息技术</a></li>
                    <li><a>电影天堂</a></li>
                    <li><a>工作之家</a></li>
                    <li><a>娱乐天地</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true"id="dropdownMenu1" >服务中心<span class="caret"></span></a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenul1">
                            <li><a href="#">贝贝论坛</a></li>
                            <li><a href="#">技术投稿</a></li>
                            <li><a href="#">寻求服务</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">乐友中心</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">关于我们</a></li>
                        </ul>
                    </li>
                  </ul>
                  <ul  class="nav navbar-nav navbar-right" id="rightUl">
                       <li   id="li.loginOrExit"><a  id="loginOrExit"></a></li>
                       <li><a href="/leyou/register.jsp" target="_blank">注册</a></li>
                  </ul>
       <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用户登录</h4>
      </div>
      <div class="modal-body">
      <div style="margin-left: 70px; margin-right: 70px">
      <form action="/leyou/myself/login" method="post" id="login.Form">   
        <div class="form-group">
          <label  class="col-sm-2 control-label">账号</label>
          <div class="col-sm-10">
           <input type="text"  id="nickName" name="nickName" class="form-control" placeholder="Name">
          </div>    
       </div>     
        <br><br>
       <div class="form-group">
          <label  class="col-sm-2 control-label">密码</label>
          <div class="col-sm-10">
            <input  type="password" id="password" name="password" class="form-control" placeholder="Password">
          </div>    
       </div> 
       <br><br>   
       <div class="form-group">
          <label  class="col-sm-2 control-label">验证</label>
          <div class="col-sm-10">
             <div class="form-group">
             <p  class="col-sm-5 control-label"><input  type="text" id="firmCode" name="firmCode" class="form-control" placeholder="identify code"></p>
             <div class="col-sm-7">
               
                  <span> <img src="/UserManager/myself/image" id="identity1" onload="btn.disabled = false "/><a onclick="reloadImage()">看不清</a></span>
             </div>    
           </div>     
          </div>    
         </div> 
        </form>
          <div   style="height:10px; text-align:center; color: red">
              <label id="error"></label>
          </div>
       </div> 
      </div>
      <br><br>
      <div class="modal-footer">
        <div style="text-align: center">
         <button type="button" class="btn btn-default" onclick="login()">点击登录</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
         <script type="text/javascript">
          function login(){
            var nickname= document.getElementById("nickName").value;
            var password= document.getElementById("password").value;
            var firmCode= document.getElementById("firmCode").value;
            if(nickname == "" || nickname == null)
                document.getElementById("error").innerHTML="请输入用户名!";
            else if(password == "" || password == null)
                document.getElementById("error").innerHTML="请输入密码!";
            else if(firmCode == "" || firmCode == null)
               document.getElementById("error").innerHTML="请输入验证码!";
            else
            {
               document.getElementById("login.Form").submit();
            }
            }
        
         </script>
       </div>
      </div>
    </div>
  </div>
</div>        
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
       </div>
    </nav>
<div class="jumbotron" id="jumbotron1">
    <div class="container" >
    <div style="width: 100%;">
    <h1>知心，明友   乐友服务</h1>
    <p>知心明友，乐友在这里我们会竭诚为您提供最为便利的计算机专业服务，微博互动说出您的困扰，我们会找专人为您答疑解惑，说出您的想法分享您的快乐，点击注册成为我们的一员，乐友大家庭等待着您的到来——乐友贝贝.
     </div>
     <div style="float: left;"> 
     <img alt="" src="img/b22c59c43f9ec0c661e69a0b69f77916.jpg" width="500px" height="300px"></div>
     <div style="float: left;margin-top: 100px;">
     <div style="margin-left: 50%">
     <a class="btn btn-primary btn-lg" href="#" >点我，了解更多&raquo;</a>
    </div>
     </div>
   </div>
    
    
      
   </div>

  
  </body>
</html>
