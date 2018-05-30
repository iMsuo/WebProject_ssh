<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Fail</title>
        <script type="text/javascript">
		var msg="${requestScope.tipMessage}";
		if(msg!=""){
			alert(msg);
		}
		window.location="${requestScope.contextPath}/WebProject${requestScope.url}";
	</script>
  </head>
  <body>
  </body>
</html>
