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
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">


 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/allown.css" type="text/css">
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
 	</head>
  
  <body>
    <div id="div1"><img src="images/timg.jpg"></img></div> 
 
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
  
   <div id="register" >
   <h2>注册</h2>
    <form action="register" method="post" onsubmit=" return register()">
    	<span>用&nbsp;户&nbsp;名</span>：<input type="text" name="username" placeholder="请输入用户名" required="required"><br/>
    	<span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</span><input type="text"name="email" id="email" placeholder="请输入E-mail地址" required="required"><br/>
    	<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" id="password" name="password" placeholder="请输入密码" required="required"><br/>
    	<span>确认密码；</span><input type="password" name="surepassword" id="surepassword" placeholder="请输入密码" required="required"><br/>
    	<span id="choosepic">选择头像：</span>
    	<div id="pic">
    	<input type="radio" name="headerpic" id="pic1" value="/WebProject/headpic/pic1.jpg"> <img  src="/WebProject/headpic/pic1.jpg">
    	<input type="radio" name="headerpic" id="pic2" value="/WebProject/headpic/pic2.jpg"> <img  src="/WebProject/headpic/pic2.jpg">
    	<input type="radio" name="headerpic" id="pic3" value="/WebProject/headpic/pic3.jpg"> <img  src="/WebProject/headpic/pic3.jpg"><br/>
    	<input type="radio" name="headerpic" id="pic4" value="/WebProject/headpic/pic4.jpg"> <img  src="/WebProject/headpic/pic4.jpg">
    	<input type="radio" name="headerpic" id="pic5" value="/WebProject/headpic/pic5.jpg"> <img  src="/WebProject/headpic/pic5.jpg">
    	<input type="radio" name="headerpic" id="pic6" value="/WebProject/headpic/pic6.jpg"> <img  src="/WebProject/headpic/pic6.jpg"><br/>
    	<input type="radio" name="headerpic" id="pic7" value="/WebProject/headpic/pic7.jpg"> <img  src="/WebProject/headpic/pic7.jpg">
    	<input type="radio" name="headerpic" id="pic8" value="/WebProject/headpic/pic8.jpg"> <img  src="/WebProject/headpic/pic8.jpg">
    	</div>
    	<br/>
    	<input type="submit" value="注册">
    </form>
</div>
  </body>
</html>
