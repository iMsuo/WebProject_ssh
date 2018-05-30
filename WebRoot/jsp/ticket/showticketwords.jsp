<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>论坛分区</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/index.js"></script>
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/showticketwords.css" type="text/css"></link>

  </head>
 
  <body> 

 <div id="top">
	<ul>
		<li><a href="${pageContext.request.contextPath}/testwords">单词测试</a><li>
		<li><a href="${pageContext.request.contextPath}/showlanmu">论坛</a></li>
		<li><a href="${pageContext.request.contextPath}/shownews">新闻</a></li>
		<li><a href="${pageContext.request.contextPath}/listenexam">听力</a></li>
		<li><a href="${pageContext.request.contextPath}/showbooks">读书</a></li>
	</ul>
  </div>
<div id="logo"><a href="${pageContext.request.contextPath}"><img src="images/logo.jpg"></img></a></div> 
  <div id="div1"><img src="images/timg.jpg"></img></div><br/>
  
   <c:choose>
	     <c:when test="${user.id!=null }">
	    	 <div id="header1" onMouseOver="showuser()" onmouseout="hideuser()">
	    	 <img src="${user.headerpic}"/>
		    	 <div id="userope">
			    	 <ul>
			    	 	<li><a href="${pageContext.request.contextPath}/showgrades"><span>个人中心</span></a></li>
				    	<li><a href="${pageContext.request.contextPath}/jsp/user/changepwd.jsp"><span>修改密码</span></a></li>
				     	<li><a href="${pageContext.request.contextPath}/logout"><span>退出登录</span></a></li>
				     </ul>
		    	 </div>
	    	 </div>
	 	 </c:when>
	 	 <c:otherwise>
  				${user.headerpic}
  			<div id="header">
	  			<a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a>&nbsp;|&nbsp;
			 	 <a href="${pageContext.request.contextPath}/jsp/userlogin.jsp">登录</a>
		 	</div>
  		</c:otherwise>
 	 </c:choose>



 	<div id="topsum"><p>发帖人:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ownuser.headerpic}">&nbsp;&nbsp;&nbsp;&nbsp;${ownuser.username}
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	主题：${ticket.subjectcontent}</p></div>
    <table>
      <c:forEach items="${ticketwords}" var="vars" varStatus="sta">
      <tr><td class="pic"><img src="${vars.userInfo.headerpic}"></td><td >${vars.userInfo.username}</td><td class="contents">${vars.words}</td></tr>
      </c:forEach>
    </table>
    
    
    
     <div id="choose">
	     <p> ${page}/${limit}</p>   
		 <span>
		 <c:if test="${page>1}"><a href="${pageContext.request.contextPath}/showticketwords?ticketid=${ticketwords[0].ticket.id}&pageno=${page-1}">上一页</a></c:if>
		                                	
		 <c:if test="${page<limit}"><a href="${pageContext.request.contextPath}/showticketwords?ticketid=${ticketwords[0].ticket.id}&pageno=${page+1}">下一页</a></c:if>
		 </span>
		</div>

<div id="formsub">
  <form method="post" action="addreplys">
 	 <input type="hidden" name="userid" value="${user.id}">
  	<input type="hidden" name="ticketid" value="${ticket.id}">
  	回复内容：<textarea name="words" rows="10" cols="80"></textarea><br/>
  	<input type="submit" value="回复">
  </form>
</div>
    
  </body>

</html>
