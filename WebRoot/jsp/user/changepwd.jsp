<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/changepwd.css" type="text/css"></link></head>
  
  <body>
    <div id="div1"><img src="images/timg.jpg"></img></div> 
  <a href=”#” onClick="javascript :history.back(-1);"><img src="img/back.jpg"></img></a><h3>欢迎用户：${user.username}</h3>
  <div id="center">
  	<p>您即将修改自己的密码,请输入您要修改的密码:</p>
  	<br>
    <form action="changepwd" method="post">
    	<input type="hidden" name="id" value="${user.id}">
    	<span>密&nbsp;&nbsp;&nbsp;&nbsp;码:</span><input type="password"name="password" placeholder="请输入密码"><br/>
    	<span>确认密码:</span><input type="password"name="surepassword" placeholder="请输入密码"><br/>
    	<br/>
    	<input type="submit" value="确认修改">
    </form>
    </div>
  </body>
</html>
