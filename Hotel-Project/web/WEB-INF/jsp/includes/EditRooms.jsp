<%-- 
    Document   : EditRooms
    Created on : 11-Apr-2017, 1:58:12 AM
    Author     : manvir
--%>
<div class="modal fade" id="editRoomModal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Edit Rooms</h4> 
            </div>
            <div class="main-login main-center" id="loginbox"style="width: 60%; margin: auto; margin-top: 30px;">
       <!-------------------------Edit rooms------------------------------------------------------>
       <form action="" id="EditingRooms" >
    <!--------------------ROOM NUMBER---------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="RoomNumber">Room Number<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="number" id="Room_Number_u"  name="Room_Number" required="required" class="form-control col-md-7 col-xs-12" readonly>
            </div>
        </div></div> 
    <!-------------------------------PACKAGE ID------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="packageId">Package ID<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="packageId_u" name="packageId" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div>
    <!---------------------------ROOM TYPE----------------------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heard">Room Type *</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <select name ="roomType" id="roomType_u" class="form-control" required="">
                    <option value="1">Single-BedRoom</option>
                    <option value="2">Double-BedRoom</option>
                    <option value="3">Triple-BedRoom</option>
                </select></div>
        </div></div>
    <!----------------------------------------Fridge---------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heard">Fridge*</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="radio">
                    <label>
                        <input type="radio" checked="" value="true" class="Fridge_u" name="Fridge"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" class="Fridge_u" name="Fridge">No
                    </label>
                </div>   
            </div>
        </div></div>
    <!----------------------------------------Wifi---------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heard">WiFi*</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="radio">
                    <label>
                        <input type="radio" checked="" value="true" class="WiFi_u" name="WiFi"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" class="WiFi_u" name="WiFi">No
                    </label>
                </div>   
            </div>
        </div></div>
    <!----------------------------------------TV---------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heard">TV*</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="radio">
                    <label>
                        <input type="radio" checked="" value="true" class="TV_u" name="TV"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" class="TV_u" name="TV">No
                    </label>
                </div>   
            </div>
        </div></div>
    <!-------------------------------PRICE------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price">Price<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="Number" min="100" max="2000" value="500" id="price_u" name="price" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div>
    <!---------------------------------------SUBMIT------------------------------------------------>
    <div id="roomResult_u" style="margin-bottom: 10px"><img src="assets/img/ajax-loader.gif"/></div>
    <div class="row pad">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-warning">Reset</button>
        </div></div>  

</form>

       
       <!--------------------------------------------------------------------------------->

            </div>
          
        </div>
    </div>
</div>
<script>
 $("#EditingRooms").submit(function(event){
       event.preventDefault();
       roomProcessingEdit();
   });
    function roomProcessingEdit(){
     $("#roomResult_u").show();  
     $("#roomResult_u").html("<img src = 'assets/img/ajax-loader.gif'/>");
     var RoomNumber = $("#Room_Number").val();
     var Fridge = $(".Fridge_u:checked").val();
     var TV = $(".TV_u:checked").val();
     var WiFi = $(".WiFi_u:checked").val();
     var price = $("#price_u").val();
     var roomType = $("#roomType_u").val();
     var packageId = $("#packageId_u").val();
     
     $.ajax({
         type: "GET",
         contentType: "application/text",
         url : "addRoom",
         data : "RoomNumber=" + RoomNumber + "&Fridge=" + Fridge + "&TV="+TV+"&WiFi="+WiFi+"&price="+price+"&roomType="
         +roomType + "&packageId="+packageId,
     success: function(data){
        
        $("#roomResult_u").html("<h3 style=color:#265a88> " + data + "</h3>");
         $("#roomResult_u").hide();
        allrooms();
     },
      error: function(e){
         alert(e);
          $("#roomResult_u").hide();
     }
     });
        
    }
    </script>
