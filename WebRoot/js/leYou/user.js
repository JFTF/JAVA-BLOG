/**
 * 
 */
function User(){}
       
     User.prototype.name = null;//使用原型来添加属性
     User.prototype.password = null;
     User.prototype.getRegister = function(){
     var patrn=/^([a-zA-Z0-9]|[._]){4,19}/;   
     this.name = document.getElementById("name").value;//使用原型来添加属性
     this.password = document.getElementById("password").value;
       if(this.name == "")
            return "用户名不能为空";
       
       else if(this.password == "")
            return "密码不能为空";
       else if(this.name.length > 10)
            return  "用户名过长";
       else if (!patrn.exec(this.password)) 
          return "密码输入错误" ;
       else 
          return  "用户输入格式合法";
      }; 
      User.prototype.getLogin = function(){
    	  var patrn=/^([a-zA-Z0-9]|[._]){4,19}/;   
    	  this.name = document.getElementById("name").value;//使用原型来添加属性
    	  this.password = document.getElementById("password").value;
    	  if(this.name == "")
    	      return "用户名输入错误";
          else if(this.name.length > 10)
    	      return  "用户名输入错误";
    	  else if (!patrn.exec(this.password)) 
    	          return "密码输入错误" ;
    	  else 
    	      return  "用户注册成功";
    }; 
    
     
