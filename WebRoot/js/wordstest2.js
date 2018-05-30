function grade(){
	var i;
	var t=0;
	var arr=new Array(5); 
	var answer1=document.getElementById("answer1");
	var answer2=document.getElementById("answer2");
	var answer3=document.getElementById("answer3");
	var answer4=document.getElementById("answer4");
	var answer5=document.getElementById("answer5");
	var que1=document.getElementsByName("w");
	var que2=document.getElementsByName("o");
	var que3=document.getElementsByName("r");
	var que4=document.getElementsByName("d");
	var que5=document.getElementsByName("s");
	for(i=0;i<que1.length;i++)
	{
		if(que1[i].checked)
			{
				arr[t]=que1[i].value;
				t++;
			}
	}
	for(i=0;i<que2.length;i++)
	{
		if(que2[i].checked)
			{
				arr[t]=que2[i].value;
				t++;
			}
	}
	for(i=0;i<que3.length;i++)
	{
		if(que3[i].checked)
			{
				arr[t]=que3[i].value;
				t++;
			}
	}
	for(i=0;i<que4.length;i++)
	{
		if(que4[i].checked)
			{
				arr[t]=que4[i].value;
				t++;
			}
	}
	for(i=0;i<que5.length;i++)
	{
		if(que5[i].checked)
			{
				arr[t]=que5[i].value;
				t++;
			}
	}
//	alert(arr[0]);
//	alert(arr[1]);
//	alert(arr[2]);
//	alert(arr[3]);
//	alert(arr[4]);
	answer1.value=arr[0];
	answer2.value=arr[1];
	answer3.value=arr[2];
	answer4.value=arr[3];
	answer5.value=arr[4];
}