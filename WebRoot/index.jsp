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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shouye.css">

  	<script type="text/javascript" src="js/index.js"></script>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
 	<script type="text/javascript" src="js/indexpic.js"></script>
  </head>
  
  <body>
  
  
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

    <div class="top"><img src="img/mianpic.jpg"></div>

<!-- 
	<div id="sub">
	 
	<ul>
		<li><a href="${pageContext.request.contextPath}/testwords">单词测试</a><li>
		<li><a href="${pageContext.request.contextPath}/showlanmu">论坛</a></li>
		<li><a href="${pageContext.request.contextPath}/shownews">新闻</a></li>
		<li><a href="${pageContext.request.contextPath}/listenexam">听力</a></li>
		<li><a href="${pageContext.request.contextPath}/showbooks">读书</a></li>
	</ul>
	
	</div>
-->
	<div class="clear"></div>
	<div class="center">
	 <div class="center_top">
	  <!-- <==========================================================> -->
					  <!-- 轮播图开始区域 -->
	 <!-- <div id="bannar"> -->
		   <div class="content_middle">
			  <div class="common_da">

					<a class="common btnLeft"href="javascript:;"></a>
					<a class="common btnRight"href="javascript:;"></a>

			  </div>
	                       		
	                       	
			   <ul>
				  <li style="background:url(index/word.png) no-repeat center center;opacity: 100;filter: alpha(opacity=1);"><span id="word1">不积跬步,无以至千里;<br>不积小流,无以成江海！</span></li>
				  <li style="background:url(index/listen.png)  no-repeat center center;"><span id="word2">三人行，必有我师焉!</span></li>
				  <li style="background:url(index/bbs.png) no-repeat center center;"><span id="word3">风声,雨声,读书声,声声入耳;<br>家事,国事,天下事,事事关心!</span></li>
				  <li style="background:url(index/news.png) no-repeat center center;"><span id="word4">所谓的耳聪,也就是倾听的意思。</span></li>
				  <li style="background:url(index/books.png) no-repeat center center;"><span id="word5">读万卷书，行万里路!</span></li>
			   </ul>
				<div class="table">
					<a class="small_active"href="${pageContext.request.contextPath}/testwords">单词测试</a>
					<a href="${pageContext.request.contextPath}/showlanmu">论坛</a>
					<a href="${pageContext.request.contextPath}/shownews">新闻</a>
					<a href="${pageContext.request.contextPath}/listenexam">听力</a>
					<a href="${pageContext.request.contextPath}/showbooks">读书</a> 
				</div>
		   </div>    	  
	 </div>    
</div>
	<div id="footer">
	  	<span>Copyright © 2017 版权所有：@hx</span>
    </div>	
  </body>
</html>
