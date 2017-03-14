<%-- 
    Document   : newjsp
    Created on : 14-Mar-2017, 2:04:09 AM
    Author     : manvir
--%>
<%----just for testing purpose-------------%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
     <%@include file="includes/Login.jsp" %>
<style>
    .pad{
        padding-bottom: 15px;
    }
</style>
<div class="container">
  
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="pill" href="#addRooms">Add Rooms</a></li>
    
    <li><a data-toggle="pill" href="#rooms">Rooms</a></li>
  </ul>
    <div class="col-md-6 col-6" style="margin-top: 30px;">
  <div id="tabs">
  <div class="tab-content">
    <div id="addRooms" class="tab-pane fade in active">
       <form action="addRooms" method="post">
           <!--------------------ROOM NUMBER---------------------------------------->
          <div class="row pad">
         <div class="form-group">
          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="RoomNumber">Room Number<span class="required">*</span>
                 </label>
             <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="RoomNumber"  id="RoomNumber" required="required" class="form-control col-md-7 col-xs-12">
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
                              <input type="radio" checked="" value="true" id="wiFi" name="WiFi"> Yes
                            </label>
                           <label>
                              <input type="radio"  value="false" id="wiFi" name="wiFi">No
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
            <!-------------------------------PACKAGE ID------------------------------------------->
           <div class="row pad">
           <div class="form-group">
          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price">Price<span class="required">*</span>
                 </label>
             <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="Number" min="100" max="2000" value="500" id="price" name="price" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div></div>
           <!---------------------------------------SUBMIT------------------------------------------------>
           <div class="row pad">
           <div class="form-group">
           <button type="submit" class="btn btn-primary">Submit</button>
         <button type="reset" class="btn btn-warning">Reset</button>
                      </div></div>  
        
        
        </form>
    </div>
    <div id="rooms" class="tab-pane fade">
      <h3>Rooms</h3>
      <p>ALL SEXY ROOMS HERE</p>
    </div>
    
  </div>
    </div>
        </div>
</div>

</body>
</html>

