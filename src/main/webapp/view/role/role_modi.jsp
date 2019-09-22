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
            //保存成功的提示消息
             $(document).ready(function() {
    		$(function() {
    			$("#sumt").click(function() {
    				$("#updateAdmin").submit();
    			});
    		});
    	});
            
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
            	<c:forEach items="${ad.lp}" var="pow">
            		<li><a href="${pow.purl}" class="${pow.pclass}"></a></li>
            	</c:forEach>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">           
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath}/UpdateRoleMessage" method="post" class="main_form" id="updateAdmin">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${role.rname }" name="roleName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium error_msg">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                           <c:forEach items="${powList}" var="pows">
                            	<li><input type="checkbox" name="pows" value="${pows.pid}"
                            		<c:forEach items="${role.lp }" var="p">
                            			<c:if test="${pows.pid==p.pid }"> 
                            				checked="checked"
                            			</c:if>
                            		</c:forEach>
                            	/>${pows.pname}</li>                           	
                            </c:forEach>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" onclick="showResult();" id="sumt"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type="hidden" name="rid" value="${role.rid }"/>
            </form> 
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
