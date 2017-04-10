/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Book(roomId){
    
    var checkin = $("#datepicker1").val();
    var checkout = $("#datepicker2").val();
   // alert("working" + roomId + checkin + checkout);
   $.ajax({
     type: "POST",
     contentType: "application/text",
     url: "book",
     data: "room_id" + roomId,
     
     success: function(data){
         $('.bookingResult').hide();
         $("#bookResult"+roomId+"").show();
         if(data == "LOGIN_REQUIRED"){
         $("#bookResult"+roomId+"").html("<a href='#' data-toggle='modal' data-target='#login' style='color: red;'> *Login Required </a>");
     }
         
     },
     error: function(e){
         alert(e);
     }
   });
}

