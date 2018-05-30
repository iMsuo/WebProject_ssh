<%@page import="model.system.Grades"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showgrades.css" type="text/css"></link></head>
  <script type="text/javascript" src="js/index.js"></script>
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
  
  
  
  
 	<h3>  欢迎用户:${user.username}</h3>
 	<div id="test">
	   <a href="${pageContext.request.contextPath}/testwords">单词测试入口</a>&nbsp;&nbsp;&nbsp;&nbsp;
	   <a href="${pageContext.request.contextPath}/listenexam">听力测试入口</a>
   </div>
   
   <%
   			int i; 
   %>
   
   <div class="showgrades">
   
   
      		<% 
   		
   			List<Grades> list=(List<Grades>)request.getAttribute("grades");
   			for(i=0;i<list.size();i++)
   			{
   				if(list.get(i).getExampart()==1)
   				{
   				    out.write("<p>您的听力成绩为（只显示最近五次记录）：</p>");
   				    i=20;
   				}
   			}
   			%>
   		<%
		i=1;
		%>
   <c:forEach items="${grades}" var="vars" varStatus="sta">	
   		<c:if test="${vars.exampart==1}">
   		
   		第<%=i%>次：${vars.grades}<br/>
   		<% 
   			i++;
   		%>
   		</c:if>
   </c:forEach>
   <% 
   		
   			List<Grades> list1=(List<Grades>)request.getAttribute("grades");
   			for(i=0;i<list1.size();i++)
   			{
   				if(list.get(i).getExampart()==2)
   				{
   				    out.write("<p>您的单词测试成绩为（只显示最近五次记录）：</p>");
   				    i=20;
   				}
   			}
   			%>
   		<%
		i=1;
		%>
   <c:forEach items="${grades}" var="vars" varStatus="sta">
	 	<c:if test="${vars.exampart==2}">
	 	第<%=i%>次：${vars.grades}<br/>
	 		<% 
   			i++;
   		%>
	 	</c:if>
   </c:forEach>
	</div>
	<%
		int count1=0,count2=0;
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
	 %>

   <c:forEach items="${grades}" var="vars" varStatus="sta">
   		<c:if test="${vars.exampart==1}">
   		<% 
   			count1++; 
   			request.setAttribute("count1", count1);
   		%>
   		</c:if><br/>
 		<c:if test="${vars.exampart==2}">
		<%
			count2++;
			request.setAttribute("count2", count2);
		 %>
		</c:if><br/>
   </c:forEach>
   
   
   <div class="showgrades">
   <c:if test="${count1==0 && count2==0}">您好，您尚未进行过任何测试！<br>
   <a href="${pageContext.request.contextPath}/testwords">单词测试</a><br/>
   <a href="${pageContext.request.contextPath}/listenexam">听力测试</a>
   </c:if>
   <c:if test="${count1==0 && count2!=0}">您好，您尚未进行过听力测试！<br>
   <a href="${pageContext.request.contextPath}/listenexam">听力测试</a>
   </c:if>
   <c:if test="${count1!=0 && count2==0}">您好，您尚未进行过单词测试！<br>
   <a href="${pageContext.request.contextPath}/testwords">单词测试</a>
   </c:if>
  </div>
     

  </body>
</html>
