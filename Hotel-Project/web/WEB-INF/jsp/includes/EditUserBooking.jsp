<%-- 
    Document   : EditUserBooking
    Created on : 12-Apr-2017, 5:31:09 PM
    Author     : manvir
--%>

<div class="modal fade" id="editUserBooking" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Booking</h4> 
            </div>
            <div class="main-login main-center" id="editBookingBox" style="width: 60%; margin: auto">
                <form name = "editBooking" class="form-horizontal"  method="get" action="${pageContext.request.contextPath}/editBooking">
                    <div class="form-group">
                        <label for="booking_id" class="cols-sm-2 control-label">Booking Id</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="booking_id" id="booking_id"  readonly />
                            </div>
                        </div>
                    </div>
                    <!-------------room number----------------->
                    <div class="form-group" >
                        <label for="room_number" class="cols-sm-2 control-label">Room Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                              
                                <input type="text" class="form-control" name="room_number" id="room_number" readonly/>
                            </div>
                        </div>
                    </div>
                    <!------username------------->
                   <div class="form-group" >
                        <label for="username_b" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                              
                                <input type="text" class="form-control" name="username_b" id="username_b" />
                            </div>
                        </div>
                    </div>
               <!------------------start date-------------------->
                <div class="form-group" >
                        <label for="start_date" class="cols-sm-2 control-label">Start Date</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                              
                                <input type="text" class="form-control" name="start_date" id="start_date" />
                            </div>
                        </div>
                    </div>
               <!---------------end date------------------------------->
                <div class="form-group" >
                        <label for="End Date" class="cols-sm-2 control-label">End Date</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                              
                                <input type="text" class="form-control" name="end_date" id="end_date" />
                            </div>
                        </div>
                    </div>
               <!-------------------------special note-------------------------------------------->
                <div class="form-group " >
                    
                        <label for="special_notes" class="cols-sm-2 control-label">Special Notes</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                              
                                <input type="text" class="form-control" name="special_notes" id="special_notes" />
                            </div>
                        </div>
                    </div>
               <!-----------------submit button-------------------->
               <div class="form-group" >
                        <div class="col-sm-12 controls">
                            <input type="submit" id="btn-login"  class="btn btn-success" value="Submit" />
                          
                        </div>
                    </div>
                </form>

            </div>
  
            <!-------------------------------->
        </div>
    </div>
</div>
