<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onlynews.css">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css" type="text/css"></link>
  	<script type="text/javascript" src="js/index.js"></script>

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

  
    <div id="sub">
  <ul>
	  <li><a href="${pageContext.request.contextPath}/onlynews?part=1">新闻区</a></li>
	  <li><a href="${pageContext.request.contextPath}/onlyarticle?part=1">文章区</a></li>
  </ul>
  </div>
  
<div id="main">
  
	 <c:forEach items="${news}" begin="0" var="vars" varStatus="sta">
	             <a href="${pageContext.request.contextPath}/revealnews?id=${vars.id}"><div class="mainnews"><img src="pic/${vars.picurl}"><span>${vars.subject}</span><br/></div></a>
	 </c:forEach>
  </div>  
      <div id="choose">
  
                               <p> ${page}/${limit}</p>
               <span>   
 <c:if test="${page>1}"><a href="${pageContext.request.contextPath}/onlyarticle?pageno=${page-1}">上一页</a></c:if>
                                	
 <c:if test="${page<limit}"><a href="${pageContext.request.contextPath}/onlyarticle?pageno=${page+1}">下一页</a></c:if>
  	  </span>
  	  </div>
  	  <div class="hotsub">
	        <h4>热门文章</h4>
      <c:forEach items="${hotnews}" begin="0" var="vars" varStatus="sta">
             <span><a href="${pageContext.request.contextPath}/revealnews?id=${vars.id}">${vars.subject}</a></span><br/>
             <p><fmt:formatDate value="${vars.time}" pattern="yyyy-MM-dd"/></p> <br/>
      </c:forEach>
      </div>
  </body>
</html>
