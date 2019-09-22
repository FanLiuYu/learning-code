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
	function deleteRole(rid) {
    	var r = window.confirm("确定要删除此角色吗？");
    	if(r) location.href="${pageContext.request.contextPath}/deleteRole?rid="+rid;
        document.getElementById("operate_result_info").style.display = "block";
    }
	function updateRole(rid) {
        location.href="${pageContext.request.contextPath}/UpdateShowRoleName?rid="+rid;
    }
            
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">当前用户:<span class="required">${ad.aname}</span>
	   		<img src="${pageContext.request.contextPath }/assets/images/logo.png"  alt="logo" class="left"/>
	   		<a href="${pageContext.request.contextPath }/existServlet">[退出]</a>            
		</div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
            	<c:forEach items="${ad.lp}" var="pow">
            		<li><a href="${pageContext.request.contextPath}${pow.purl}" class="${pow.pclass}"></a></li>
            	</c:forEach>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="post">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/addRole'"/>
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath }/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr> 
                        <c:forEach items= "${roleList}" var = "role">
                        	 <tr>
                        		<td>${role.rid}</td>
                        		<td>${role.rname }</td>
                        		<td>${role.powName }</td>  
                        		<td>
                        			<input type="button" value="修改" class="btn_modify" onclick="updateRole('${role.rid}');"/>
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole('${role.rid}');" />
                        		</td>                      		                   		 
	                         </tr>
                        </c:forEach>
                                                                  
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
