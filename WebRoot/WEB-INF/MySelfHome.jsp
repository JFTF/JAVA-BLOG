<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的贝贝家</title>
    
	
	
	
   
    <script type="text/javascript" src="js/json2.js"></script>
    <link href="css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script src="js/bootstrap/jquery.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
   
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


   <script>
   		var city="";
   		var weather = {city:"",weather:"",cladIndex:""};
     $(document).ready(function() {
   
     var city="";
        $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){ 
              city= remote_ip_info.city; 
              $.ajax({
        type:"post",
        data:{city:city},
        dataType: "json",
        url:"/leyou/myself/weatherLocal",
        success:function(data){
      //   var  weather=eval(data);
         weather.city= data.city;
       
         
         weather.weather = data.weather.substr(0,33);
         weather.cladIndex = data.cladIndex.substr(53,23);
        },
       complete:function(data){
         document.getElementById("weather").innerHTML=" "+"${sessionScope.nickName}"+" 您好!"+weather.city+"&nbsp;&nbsp;"+weather.weather+"&nbsp;&nbsp;"+weather.cladIndex;
       }
        });
     
	
     });
      
       
   });
    function sendBlog(){
        var nickName = document.getElementById("nickname").value;
        var password = document.getElementById("password").value;
        
        var blogInfo = {nickName:nickName,password:password};
        $.ajax({
        type:"post",
        data:blogInfo,
        url:"/leyou/myself/blog",
        success:function(data){
          alert(data);
        },
        error:function(data){},
        });
     }
</script>
<style type="text/css">
 
    
    .buttom-hover{
      border-bottom: 5px  solid #66B3FF;
    
    }
    .head-class{
       width:100 %;
       font-size:17px;
       background-color:#66B3FF;
       height:70px;
        }
        .upDiv{
           margin-bottom:5px;
           margin-left: 50px;
           position: relative;
        
        }
         .upInput
        {
             opacity:0;
            filter:alpha(opacity=0);
            height:75px;
            width: 80px;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 9;
        }
   
  </style>
 
  
  </head>
  
  <body>
  
  <div class="head-class" id="head-id">
      <div class="upDiv">
        
        <form id="submit_form" name="submit_form" class="form_img_head" method="post" action="/leyou/blog/image/head"  enctype="multipart/form-data">  
        <input  class="upInput" type="file" name="upload_file" id="upload_file"    title="更换头像"  onchange="yulan()">  
        </form>
        <p>  <img src="img/user/${sessionScope.nickName}/1.png" width="70px" class="img-circle" height="70px">
      <label id="weather"></label></p>
      </div>
  </div>
  <div>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" >
    <li style="display:inline;" ><a href="/leyou/index.jsp">首页</a></li>
    <li class="active"><a href="#profile"   data-toggle="tab">我的资料</a></li>
    <li ><a href="#messages"   data-toggle="tab">我所关注</a></li>
    <li ><a href="#settings"   data-toggle="tab" onclick="check()">文章管理</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div  class="tab-pane active" id="profile">
    <div style="margin-top:50px;margin-left: 100px;margin-right: 100px">
       <div style="margin-left: 200px">
          <table style="height:200px ">
            <thead class="buttom-hover"><tr>
            <th style="width: 150px;font-style: inherit; font-size: 20px">基本信息</th>
            <th style="width: 350px;"></th>
            <th style="width: 100px;text-align: center;font-size: 15px;font-style: italic;"><a>编辑</a></th></tr></thead>
        <tbody style="font-style: inherit; font-size: 18px"><tr >
           <td ><b>真实姓名：</b></td><td colspan="2"></td></tr>
           <tr><td><b>性别：</b></td><td colspan="2"></td></tr>
           <tr><td ><b>年龄：</b></td><td colspan="2"></td></tr>
           <tr><td ><b>所在地：</b></td><td colspan="2"></td></tr>
           <tr><td ><b>爱好：</b></td><td colspan="2"></td></tr>
        </tbody>
          </table>
          <br><br>
          <table style="width:600px ">
             <thead class="buttom-hover"><tr><th style="text-align: center"><h2>我的故事</h2></th></tr></thead>
             <tfoot><tr><th style="text-align: center"><a>+添加故事</a></th></tr></tfoot>
          </table>
       </div>
    </div>
  
    </div>
     <script>
function yulan()
{ 
var fileext=document.submit_form.upload_file.value.substring(document.submit_form.upload_file.value.lastIndexOf("."),document.submit_form.upload_file.value.length);
        fileext=fileext.toLowerCase();
         alert( fileext);
        if ((fileext!='.jpg') && (fileext!='.gif') && (fileext!='.jpeg') && (fileext!='.png') && (fileext!='.bmp'))
        {
            alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 ！");
            document.submit_form.upload_file.value = "";
             document.submit_form.UpFile.focus();
        }
        else
        $("#submit_form").submit();
 
}
</script>
 
 
    <div  class="tab-pane" id="messages">...</div>
    <div  class="tab-pane" id="settings">
    <div id="My-no-blog-id" class="My-no-blog-class">
    <div style="margin-left: 100px; margin-right: 100px; margin-top: 50px;">
     
   <table class="table table-hover"> 
      <thead>
      <tr style="font-size: 15px; font-family: fantasy;"><th style="width:400px">标题</th><th style="width:100px">状态</th><th style="width:100px">评论权限</th><th style="width:200px">操作</th></tr>
      </thead>
      <tbody ><tr><td>sss</td></tr></tbody>
      <tfoot style="text-align: center"><tr><td colspan="4"><button type="button" class="btn btn-primary btn-lg active">+ 编写博文</button></td></tr></tfoot>
  </table>
    </div>
    </div>
    </div></div></div></body></html>
