<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global_color.css" /> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript">
          $(function(){
        	  var reguser=/^[A-Za-z0-9].{2,8}$/;
        	  $("#user").blur(function(){
        		  if(!reguser.test($("#user").val())){
        			  $("#sp1").text("用户名必须为3到8位字母或数字");
        		  }
        	  });
        	  $("#pwd").blur(function(){
        		  if(!reguser.test($("#pwd").val())){
        			  $("#sp2").text("密码必须为3到8位字母或数字");
        		  }
        	  });
        	  $("#smt").click(function(){
        		  if(reguser.test($("#user").val())&&reguser.test($("#pwd").val())){
        			  $("#login_form").submit();
        		  }else{
        			  $("#sp3").text("用户名或密码格式不正确！");
        		  }
        	  });
          });
        </script>
    </head> 
    <body class="index">
        <div class="login_box">
        <form id="login_form" action="${pageContext.request.contextPath}/logAdmin" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="user" name="acname" type="text" class="width150" /></td>
                    <td class="login_error_info"><span id="sp1" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="pwd" name="apwd" type="password" class="width150" /></td>
                    <td><span id="sp2" class="required"></span></td>
                </tr>          
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a id="smt"><img src="${pageContext.request.contextPath}/assets/images/login_btn.png" /></a>
                    </td>    
                      <td><span id="sp3" class="required"></span></td>           
                </tr>
            </table>
         </form>
        </div>
    </body>
</html>
