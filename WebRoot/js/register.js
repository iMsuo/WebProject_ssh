function register(){
	var check=true;
	var pwd1=document.getElementById("password").value.trim();
	var pwd2=document.getElementById("surepassword").value.trim();
	var email=document.getElementById("email").value.trim();
	if(pwd1!=pwd2)
	{
		alert("两次密码输入不一致，请确认后重新输入！");
		return false;
	}
	if(!ismail(email))
	{
		alert("请输入正确的邮箱密码");
		return false;
	}
	return check;
}

function ismail(str){
	var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}