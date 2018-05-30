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
    
    <title>推书界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/showbooks.css">
		<script type="text/javascript" src="js/index.js"></script>

  </head>
  
  <link rel="stylesheet" href="css/style.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/YuxiSlider.jQuery.min.js"></script>

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
  
  
  
  
  
  <center>
<div class="demo">
	<a class="control prev"></a><a class="control next abs"></a><!--自定义按钮，移动端可不写-->
	<div class="slider"><!--主体结构，请用此类名调用插件，此类名可自定义-->
		<ul>
		
			 <c:forEach items="${bookslists}" begin="0" var="vars" varStatus="sta">
	          		<li><a href="${pageContext.request.contextPath}/showbooklists?booklistid=${vars.id}"><img src="${vars.booklistPicurl}"></a><br/></li>
	 		</c:forEach>

		</ul>
	</div>
</div>
</center>
<div id="show">
    <a href="${pageContext.request.contextPath}/showbook?id=${hotbook.id}" target="_blank"> 
	<div class="part">
	<p>最受欢迎</p>
		<img src="${hotbook.bookPicurl }"/>
		<span>${hotbook.bookname}</span>
		<span>作者：${hotbook.author}</span>
	</div>
	</a>
	  <a href="${pageContext.request.contextPath}/showbook?id=${lastbook.id}" target="_blank">
	<div class="part">
	<p>最新更新</p>
	<img src="${lastbook.bookPicurl}"/>
		<span>${lastbook.bookname}</span>
		<span>作者：${lastbook.author}</span>
	</div>
	</a>
	 <a href="${pageContext.request.contextPath}/showbook?id=${random.id}" target="_blank">
	<div class="part">
	<p>随机推荐</p>
	<img src="${random.bookPicurl}"/>
		<span>${random.bookname}</span>
		<span>作者：${lastbook.author}</span>
	</div>
	</a>
</div>

  <script>
$(".slider").YuxiSlider({
	width:1080, //容器宽度
	height:370, //容器高度
	control:$('.control'), //绑定控制按钮
	during:3000, //间隔4秒自动滑动
	speed:800, //移动速度0.8秒
	mousewheel:true, //是否开启鼠标滚轮控制
	direkey:true //是否开启左右箭头方向控制
});
</script>
</body>
</html>
