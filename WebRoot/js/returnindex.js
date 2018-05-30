var secs=3;
var URL;
function Load(url){
	alter("123");
	URL=url;
	for(var i=secs;i>=0;i--){
		window.setTimeout('doUpdate('+i+')', (secs-1)*1000);
	}
}
function doUpdate(num){
	document.getElementById("show").innerHTML='将在'+num+'秒后跳至主页';
	if(num==0){window.location=URL;}
}
