<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" media="all"
	href="${pageContext.request.contextPath}/assets/css/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="${pageContext.request.contextPath}/assets/css/global_color.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#smt").click(function(){
			 $(".main_form").submit();
		 });
	 });
	</script>  
	</head>
	<body>
	<!--Logo区域开始-->
	<div id="header">当前用户:${ad.aname}
	   <img src="${pageContext.request.contextPath }/assets/images/logo.png"  alt="logo" class="left"/>
	   <a href="${pageContext.request.contextPath }/existServlet">[退出]</a>            
	</div>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi">
	     <ul id="menu">
	       <c:forEach items="${ad.lp }" var="pr">
	          <li><a class="${pr.pclass }"  href=" ${pageContext.request.contextPath }${pr.purl }"></a></li>
	       </c:forEach>
	       
	   </ul>
	</div>
	<!--导航区域结束-->
	<div id="main">      
	   <!--保存操作后的提示信息：成功或者失败-->      
	<%--             <div id="save_result_info" class="save_fail">${errorMsg }</div><!--保存失败，旧密码错误！--> --%>
	       
	   <form action="${pageContext.request.contextPath}/updateAdminPassword" method="post" class="main_form">
	       <div class="text_info clearfix"><span>旧密码：</span></div>
	       <div class="input_info">
	           <input name="oldPwd" type="password" class="width200"  /><span class="required">*${errorMsg1 }</span>
	           <div class="validate_msg_medium"></div>
	       </div>
	       <div class="text_info clearfix"><span>新密码：</span></div>
	       <div class="input_info">
	           <input  name="newPwd"  type="password"  class="width200" /><span class="required">*</span>
	           <div class="validate_msg_medium"></div>
	       </div>
	       <div class="text_info clearfix"><span>重复新密码：</span></div>
	       <div class="input_info">
	           <input  name="renewPwd"type="password" class="width200"  /><span class="required">*${errorMsg }</span>
	           <div class="validate_msg_medium"></div>
	       </div>
	       <div class="button_info clearfix">
	           <input id="smt" type="submit" value="保存" class="btn_save"  />
	           <input type="button" value="取消" class="btn_save" />
	       </div>
	   </form>  
	</div>
	<!--主要区域结束-->
	<div id="footer">   
	</div>
	</body>
</html>