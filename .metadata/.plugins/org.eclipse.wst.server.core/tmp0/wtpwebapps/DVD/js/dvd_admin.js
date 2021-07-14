function openInsertPopUp()
{
	const url = "/DVD/index/dvd_admin/insert";
	const name = "insertPopUp";
	const option = "width = 500, height=750, top = 100, left = 200, location=no";
	
	window.name = url;
	window.open(url,name,option);
}


function submitInsertPopUp()
{	
	document.insert_form.target = opener.name;
	
	document.insert_form.action = "/DVD/index/dvd_admin/insert";
	document.insert_form.submit();	
	
	if(opener != null)
	{
		opener.insertPopUp = null;
		
		self.close();
	}	
}
