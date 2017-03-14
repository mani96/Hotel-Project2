<%-- 
    Document   : checkAvailability
    Created on : 13-Mar-2017, 3:53:59 PM
    Author     : manvir
--%>

<div class="container-fluid well" style="padding-bottom: 100px;">
	 <div class="container" >
	<div class="checkForm" style="text-align: center">
	  <div class="row">
	    <form action="" method="post">
		   <div class="col-3 col-md-3">
		   <div class="input-group date mg-check-in">
							<div class="input-group date mg-check-in">
                   
			<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
			<input type="text" class="form-control" id="datepicker1" placeholder="Check-In Date">
			</div>
										</div>

		   </div>
		   <div class="col-3 col-md-3">
		    <div class="input-group date mg-check-in">
			<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
			<input type="text" class="form-control" id="datepicker2" placeholder="Check-Out Date">
			</div>
		   
		   </div>
		   <div class="col-3 col-md-3">
		   <select class="select_room" data-style="btn-primary" onchange="roomType(this.value)" >
      <option value="1">Single-Bed Room</option>
      <option value="2">Double-Bed Room</option>
      <option value="3">Triple-Bed Room</option>
  </select>
		   </div>
		   <div class="col-3 col-md-3">
		    <div class="row">
			<div id="Sadults">
			
			</div>
			</div>
			<div class="row">
			<div id="Skids">
			
			</div>
			</div>
		   </div>
		   <div class="row">
		 <button type="submit" class="btn btn-primary">Check Availability</button>
		   </div>
		   <div class="row">
		   <div id="result">
		   RESULT
		   </div>
		   </div>

		</form>
 	  </div>
	  </div>
	</div>
		
	</div>