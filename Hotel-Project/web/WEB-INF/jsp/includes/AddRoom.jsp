<%-- 
    Document   : AddRoom
    Created on : 14-Mar-2017, 4:48:03 PM
    Author     : manvir
--%>

<form action="" id="addingRooms" >
    <!--------------------ROOM NUMBER---------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="RoomNumber">Room Number<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="number" id="Room_Number"  name="Room_Number" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!-------------------------------PACKAGE ID------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="packageId">Package ID<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="packageId" name="packageId" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div>
    <!---------------------------ROOM TYPE----------------------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heard">Room Type *</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <select name ="roomType" id="roomType" class="form-control" required="">
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
                        <input type="radio" checked="" value="true" id="Fridge" name="Fridge"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" id="Fridge" name="Fridge">No
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
                        <input type="radio" checked="" value="true" id="WiFi" name="WiFi"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" id="WiFi" name="WiFi">No
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
                        <input type="radio" checked="" value="true" id="TV" name="TV"> Yes
                    </label>
                    <label>
                        <input type="radio"  value="false" id="TV" name="TV">No
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
                <input type="Number" min="100" max="2000" value="500" id="price" name="price" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div>
    <!---------------------------------------SUBMIT------------------------------------------------>
    <div id="roomResult"></div>
    <div class="row pad">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-warning">Reset</button>
        </div></div>  

</form>
<script>
   $("#addingRooms").submit(function(event){
       event.preventDefault();
       roomProcessing();
   });
    function roomProcessing(){
        $("#roomResult").empty();
     var RoomNumber = $("#Room_Number").val();
     var Fridge = $("#Fridge").val();
     var TV = $("#TV").val();
     var WiFi = $("#WiFi").val();
     var price = $("#price").val();
     var roomType = $("#roomType").val();
     var packageId = $("#packageId").val();
     
     $.ajax({
         type: "GET",
         contentType: "application/text",
         url : "addRoom",
         data : "RoomNumber=" + RoomNumber + "&Fridge=" + Fridge + "&TV="+TV+"&WiFi="+WiFi+"&price="+price+"&roomType="
         +roomType + "&packageId="+packageId,
     success: function(data){
        $("#roomResult").html("<h3 style=color:#265a88> " + data + "</h3>");
     },
      error: function(e){
         alert(e);
     }
     });
        
    }
    </script>
    