$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
	
	$("#deleteAll").click(function() {
		var arr = []; 
	    $("input:checkbox[name=delete]:checked").each(function() { 
	        arr.push($(this).val()); 
	    });
	    document.location.href = "manage/delete-batch?ids=" + arr;
        //$.post("manage/delete-batch", {ids : arr});
	});
	
});