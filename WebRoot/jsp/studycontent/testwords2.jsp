<%@page import="model.system.Words"%>
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
    
    <title>单词测试界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/testwords.css">
	<script type="text/javascript"
    src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.js"></script> 
	<script src="${pageContext.request.contextPath }/js/wordstest2.js">
	
	</script>
	<script type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body onload="showques()">
          <!--成绩一：${param.grade1}  -->
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
          
          
          
   <h3>请回答以下问题：</h3>
    
  
   <table>
	   <tr>
	   		<td>
	   			1.${words[0].word}<br/>
	   			<c:forEach var="varss" begin="0" step="1" end="3" items="${meaning}" varStatus="stas" >
	   			<input type="radio" id="w${stas.count}" name="w" value="${varss}"/>
				<label for="w${stas.count}"><span>${stas.count}.${varss}</span></label>
				<br/>
				</c:forEach>
				<br/>
	   		</td>
	   	</tr>

	   	  <tr>
	   		<td>
	   			2.${words[1].word}<br/>
	   			<c:forEach var="varss" begin="4" step="1" end="7" items="${meaning}" varStatus="stas" >
	   			<input type="radio" id="o${stas.count}" name="o" value="${varss}"/>
				<label for="o${stas.count}"><span>${stas.count}.${varss}</span></label>
				<br/>
				</c:forEach>
				<br/>
	   		</td>
	   	</tr>
	   	  <tr>
	   		<td>
	   			3.${words[2].word}<br/>
	   			<c:forEach var="varss" begin="8" step="1" end="11" items="${meaning}" varStatus="stas" >
	   			<input type="radio" id="r${stas.count}" name="r" value="${varss}"/>
				<label for="r${stas.count}"><span>${stas.count}.${varss}</span></label>
				<br/>
				</c:forEach>
				<br/>
	   		</td>
	   	</tr>
	   	
	   	  <tr>
	   		<td>
	   			4.${words[3].word}<br/>
	   			<c:forEach var="varss" begin="12" step="1" end="15" items="${meaning}" varStatus="stas" >
	   			<input type="radio" id="d${stas.count}" name="d" value="${varss}"/>
				<label for="d${stas.count}"><span>${stas.count}.${varss}</span></label>
				<br/>
				</c:forEach>
				<br/>
	   		</td>
	   	</tr>



   	   	  <tr>
	   		<td>
	   			5.${words[4].word}<br/>
	   			<c:forEach var="varss" begin="16" step="1" end="19" items="${meaning}" varStatus="stas" >
	   			<input type="radio" id="s${stas.count}" name="s" value="${varss}"/>
				<label for="s${stas.count}"><span>${stas.count}.${varss}</span></label>
				<br/>
				</c:forEach>
				<br/>
	   		</td>
	   	</tr>
</table>
	   	<form method="post" action="getgrade">
	   		<input type="hidden" id="answer1" name="answer1">
	   		<input type="hidden" id="answer2" name="answer2">
	   		<input type="hidden" id="answer3" name="answer3">
	   		<input type="hidden" id="answer4" name="answer4">
	   		<input type="hidden" id="answer5" name="answer5">
	   		<input type="submit" value="提交  " onclick="grade()">
	   	</form>
  </body>
</html>
