<%-- 
    Document   : Modals
    Created on : 10-Apr-2017, 2:33:23 PM
    Author     : manvir
--%>

<div class="modal fade" id="requiredInfo" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">${resname}</h4> 
            </div>
            <div class="main-login main-center" style="width: 60%; margin: auto">
                <form id="finalBooking" name = "finalBooking" class="form-horizontal"  method="post">
                    <div class="form-group">
                        <label for="roomNo" class="cols-sm-2 control-label">Room Number</label>
                        
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="text" class="form-control" name="roomNo" id="roomNo"  placeholder="Room Number" readonly/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                           
                        <div class="col-sm-6">
                            
                                <input type="text" class="form-control" name="checkInDate2" id="checkInDate2" readonly/>
                            
                        </div>
                        <div class="col-sm-6">
                                <input type="text" class="form-control" name="checkOutDate2" id="checkOutDate2" readonly/>
                        </div>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="specialService" class="cols-sm-2 control-label">*Any especial services </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                               <textarea rows="5" cols="50" id="specialService"> </textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit" onclick="test3()">Book</button>
                    </div>
                </form>

            </div>
            
        </div>
    </div>
</div>
            <script>
               
       $("#finalBooking").submit(function (event) {
        event.preventDefault();
         processing()
    });
    function processing(){
        
        var roomId = $("#roomNo").val();
        var specialNote = $("#specialService").val();
        var checkInDate2 = $("#checkInDate2").val();
        var checkOutDate2 = $("#checkOutDate2").val();
        if(specialNote == ""){
            specialNote = " ";
        }
        $.ajax({
     type: "POST",
     contentType: "application/text",
     url: "book",
     data: "room_id=" + roomId + "&special_note='" + specialNote + "'&start_date=" + checkInDate2+"&end_date="+ checkOutDate2,
     
     success: function(data){
        alert(data);    
         
     },
     error: function(e){
         alert(e);
     }
   });
    }
     $("#specialService").text(""); 
            </script>

