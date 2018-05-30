function grade(){

	var theNum=0;
	var theCheckboxInputs=document.getElementsByName("words");
	for (var i=0;i<theCheckboxInputs.length;i++)
	{
	if(theCheckboxInputs[i].checked) theNum++;
	}
	//alert(theNum);
	var grade1=document.getElementById("grade1");
	grade1.value=theNum;	
}