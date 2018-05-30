<%@ page language="java" pageEncoding="utf-8"%>
<!-- 导入struts2标签库 -->
<%@taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<html> 
<head>
   <title>用户登录</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
 <a href=”#” onClick="javascript :history.back(-1);"><img src="../img/back.jpg"></img></a>
<div id="login">
         <h1>登录</h1>
      <form action="${pageContext.request.contextPath}/login" method="post">
     	<span>用户名：</span><input type="text" name="username" required="required" ><br/>
        <span>密&nbsp;&nbsp;码：</span><input type="password" name="password" required="required" ><br/>
        <input type="submit" value="登录"><div id="re"><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></div>
     </form>
</div>
    <div id="div1"><img src="../images/timg.jpg"></img></div> 
</body>
</html>
