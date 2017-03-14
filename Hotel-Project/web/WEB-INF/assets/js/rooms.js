/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
	//alert($(".select_room").val());
	room($(".select_room").val());
	});
	
	
	function room(val){
	var i = Number(val) ;
	var arr = [];
	var adults = "<select class='select_stuff form-control' data-style='btn-primary' >";
	var kids = "<select class='select_stuff form-control' data-style='btn-primary' >";
	
	for(var j = 0; j < i; j++){
	   arr.push(j);
	}
	//alert(arr);
	for(var j = arr.length; j > -1; j--){
	  adults += "<option value='"+j+"'>"+ j + "</option> ";
	  
	  if(j < 3){
	  kids += "<option value='"+j+"'>"+ j + "</option> ";
	  }
	}
	kids += "</select>";
	adults +="</select>";
	
	document.getElementById("Sadults").innerHTML = adults;
	document.getElementById("Skids").innerHTML = kids;
	}
	
	function roomType(value){
	room(value);
	}