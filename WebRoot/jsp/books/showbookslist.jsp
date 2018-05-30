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
    
    <title>书单界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/showbookslist.css">


  </head>
  


  <body>
  
  <div id="div1"><img src="img/bac1.jpg"></img></div> 
  <div id="main">
			 <c:forEach items="${books}" begin="0" var="vars" varStatus="sta">
			 <a href="${pageContext.request.contextPath}/showbook?id=${vars.books.id}" target="_blank">
			 <div class="part">
			 <img src="${vars.books.bookPicurl}">
	         <div class="center"><span>${vars.books.bookname}</span></div>
	         </div>		
	         </a>
	 		</c:forEach>

 </div>
 <div id="side">

	         <h2>${lists.booklistName}</h2>
 			<span>${lists.booklistDiscrip}</span>
	
 </div>
</body>
</html>
