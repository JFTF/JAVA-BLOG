<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/json2.js"></script>
	<script type="text/javascript" src="js/amazeui/jquery.min.js"></script>
    <script type="text/javascript" src="js/amazeui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/amazeui.min.css">
     <script type="text/javascript">
      
    var jsonDate ;
         $.ajax({
            type:"post",
            async: false,
            url:'/leyou/blog/find',
          
          success:function(data){
         
           jsonDate = eval(data);
      
         },
            error:function(data){
            alert("error");
            } });
       
          $(document).ready(function(){
         document.getElementById("editingBlog").href="/leyou/blog/editing?nickName="+nickName;
        
          autocreate();
           $("#blog_img_head").css("background-image","url(/leyou/img/blog/head/45v58PICZ2x_1024副本.png)");
      
       
     });
         var nickName = "${requestScope.nickName}";
     
      
        function message(){
          
           var tell  = document.getElementById("tell").value;
           var education = document.getElementById("education").value;
       
        
           var interest = null;
              for (var i=0;i<interesting.length;i++ ){
                if(interesting[i].checked){ //判断复选框是否选中
                interest=interest+interesting[i].value + ","; //值的拼凑 .. 具体处理看你的需要,
               }
            }


           var blogInfo = {nickName:nickName,tell:tell,education:education,interest:interest};
           $.ajax({
            type:"post",
            url:'/Dream/ourself/blogInfo',
            data:blogInfo,
            success:function(data){
             alert(data);
            },
            error:function(data){
           
             }
           });
          };
         
       function autocreate(){
        for(var i=0;i<jsonDate.length;i++){
         var   blogInfo = new Array();
         blogInfo[0] = jsonDate[i].blogInfo.title;
         blogInfo[1] = jsonDate[i].blogInfo.category;
         blogInfo[2] = jsonDate[i].blogInfo.nickName;
         blogInfo[3] = jsonDate[i].blogInfo.interest;
         blogInfo[4] = jsonDate[i].blogInfo.id;
        
         var s= jsonDate[i].blogInfo.content;
         blogInfo[5] = s.substring(0,50);
         var  div=document.createElement("div");
        
         div.setAttribute("class","div_blog_info");
        
         var table=document.createElement("table");
         var tr=document.createElement("tr");
         
      
         var td2=document.createElement("td");
         td2.setAttribute("class","table_td2");
         var td3=document.createElement("td");
         td3.setAttribute("class","table_td3");
          
       
          td2.innerHTML = "博主："+ blogInfo[2]+ "<br>博客类别"+blogInfo[1]+"<br>个人爱好"+ blogInfo[3];
          td3.innerHTML = "博客标题："+blogInfo[0]+"<br>博客内容:"+blogInfo[5] +"<a href='/Dream/showblog.jsp?id="+blogInfo[4]+"'>查看全文</a>";
       
           tr.appendChild(td2);
           tr.appendChild(td3);
           table.appendChild(tr); 
           div.appendChild(table);
            document.getElementById("blogSerch").appendChild(div);
          }
        
          
    }
      
       
     </script>
     <style type="text/css">
      .div_blog_serchInfo{width:60%;margin-left: 30%; margin-right:10px; margin-top:100px; background-color:blue;}
      .div_blog_info{width:80%; margin-top:30px; background-image: url("img/Y$3_6X5QOE{){ZGO_SB0J4X.png");background-size:100% 100%; margin-left:50px }
   
      .table_td2{width:200px; height:120px;}
      .table_td3{width:300px; height:120px;}
     .blog_img_head{width:100px; height:100px; }
    
     </style>
     
  </head>

  <body>
   
  
   <header class="am-topbar">
  <h1 class="am-topbar-brand">
    <label id="title1">${nickName}</label>
  </h1>
   
  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
  
  <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav">
      <li class="am-active"><a href="#">首页</a></li>
     

      <li><a href="#"></a></li>
      <li><a id="editingBlog" target="_blank" >编辑博文</a></li>
  </ul>
   <form class="am-topbar-form am-topbar-left am-form-inline" role="search">
      <div class="am-form-group">
        <input type="text" class="am-form-field am-input-sm" placeholder="搜索">
      </div>
    </form>

     

    <div class="am-topbar-right">
      <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
        <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle" data-am-dropdown-toggle>其他 <span class="am-icon-caret-down"></span></button>
        <ul class="am-dropdown-content">
          <li><a href="#">什么是博客？</a></li>
          <li><a href="#">随便看看</a></li>
    
        </ul>
      </div>
    </div>
      <div class="am-topbar-right">
      <button  type="button"
  class="am-btn am-btn-primary  am-topbar-btn am-btn-sm"
  data-am-modal="{target: '#my-alert'}">编辑个人信息</button>
    </div>
 </div>
 
</header>
    <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">编辑博客信息</div>
    <div class="am-modal-bd">
 
    <div class="blog_img_head" id="blog_img_head" style="float: left ;"  >
    </div>
    <div style="width:80%; height:100px; float: left;text-align: left">
   <form id="submit_form" class="form_img_head" method="post" action=""  enctype="multipart/form-data">
       <input type="file" name="upload_file" id="upload_file" style="border: 1px solid gray;">  <!-- 添加上传文件 -->
     
   </form>
     <input type="button" value="更改头像">
  </div>
                           说说:<input type="text" id="tell"><br><br>
                           学历:<input type="text" id="education"><br>
       
        <label>兴趣爱好</label><br>
                           计算机：<input type="checkbox" name="interest" id="interesting" value="computer">
                           摄影：    <input type="checkbox" name="interest" id="interesting" value="photography">
                           哲学：    <input type="checkbox" name="interest" id="interesting" value="philosophy">
                           商业：   <input type="checkbox" name="interest" id="interesting" value="business"><br>
                           教育 ：  <input type="checkbox" name="interest" id="interesting" value="education">
                           地理：  <input type="checkbox" name="interest" id="interesting"  value="geography">  
                            时事： <input type="checkbox" id="interesting"   value="currentEvent">    
    </div>
    <div class="am-modal-footer" style="text-align:center">
       <button class="am-modal-btn" onclick="message()" >确定</button>
        &nbsp;&nbsp;
       <button class="am-modal-btn">取消</button>
    </div>
  </div>
</div>
  <div class="div_blog_serchInfo" id="blogSerch">
    
 </div>
  </body>
</html>
