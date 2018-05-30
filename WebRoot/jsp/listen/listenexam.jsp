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
    
    <title>听力测试界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<SCRIPT language=javascript>
				document.onkeydown=function()
				{
				  if ((window.event.keyCode==116)|| //屏蔽 F5
				      (window.event.keyCode==122)|| //屏蔽 F11
				      (window.event.shiftKey && window.event.keyCode==121) //shift+F10
				     )
				     { 
				          window.event.keyCode=0;
				          window.event.returnValue=false;
				     } 
				  if ((window.event.altKey)&&(window.event.keyCode==115))
				     { 
				         //屏蔽Alt+F4
				         window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
				         return false;
				     }  
				}
	</SCRIPT>

  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/listenexam.css" type="text/css"></link>
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
  
  
  
  <h3>请听以下一段录音并完成题目</h3>
  <div id="test">
	  <audio controls>
	  <source src="${ques[0].mp3.mp3Url}" type="audio/mpeg">
	  Your browser does not support this audio format.
	  </audio>
	 <form action="listengrades" method="post">
	 	<input type="hidden" name="mp3id" value="${ques[0].mp3.id}">
		 <c:forEach items="${ques}" begin="0" var="vars" varStatus="sta">
		        <p>第${sta.count}题: </p><br/>
		        <label><input name="que${sta.count}" type="radio" value="1" />${vars.listenoptionA} </label> <br/>
		        <label><input name="que${sta.count}" type="radio" value="2" />${vars.listenoptionB} </label> <br/>
		        <label><input name="que${sta.count}" type="radio" value="3" />${vars.listenoptionC} </label> <br/>
		        <label><input name="que${sta.count}" type="radio" value="4" />${vars.listenoptionD} </label> <br/>
		 </c:forEach>
		 <input type="submit" value="提交">
 	 </form>
   </div>
</body>
</html>
