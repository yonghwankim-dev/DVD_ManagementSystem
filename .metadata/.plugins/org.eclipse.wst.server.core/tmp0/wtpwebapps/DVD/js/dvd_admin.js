
const option = "width = 500, height=750, top = 100, left = 200, location=no";
function openInsertPopUp()
{
	const url = "/DVD/index/dvd_admin/insert";
	const name = "insertPopUp";
	
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

function selectAll(selectAll)
{
	const checkboxes = document.querySelectorAll("input[type='checkbox']");
	
	checkboxes.forEach((checkbox) =>{
		checkbox.checked = selectAll.checked
	});
}