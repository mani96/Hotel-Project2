<%-- 
    Document   : Admin
    Created on : 13-Mar-2017, 4:40:37 PM
    Author     : manvir
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>

    </head>
    <body>

        <!---------------------------navigation + slider--------------------->
        <%@include file="includes/navigation.jsp" %>

        <!--------admin form for editing adding rooms--------->
        <style>
            .pad{
                padding-bottom: 15px;
            }
        </style>
        <div class="container" style="margin-top: 10px">
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />

            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#user">Add Users</a></li>
                <li ><a data-toggle="pill" href="#addRooms">Add Rooms</a></li>

                <li><a data-toggle="pill" href="#rooms">Rooms</a></li>
            </ul>
            <div class="col-md-12 col-12" style="margin-top: 30px;">
                <div id="tabs">
                    <div class="tab-content">
                        <!-------------------------------Add users--------------------------------->
                        <div id="user" class="tab-pane fade in active col-md-6 col-6">
                            <%@include file="includes/AddUser.jsp" %>
                        </div>
                        <!--------------------------------Add rooms form-------------------------->
                        <div id="addRooms" class="tab-pane fade col-md-6 col-6">
                            <%@include file="includes/AddRoom.jsp" %>
                        </div>
                        <!------------------------------------Rooms list for edit or delete------------------>
                        <div id="rooms" class="tab-pane fade" style= "width: 100%">
                            <h3>Rooms</h3>
                            <p id="allrooms">ALL SEXY ROOMS HERE</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!-------------------footer------------------------>
            <%@include file="includes/Login.jsp" %>
            <%@include file="includes/EditRooms.jsp" %>
            <div class="footer-clean">
                <footer>
                    <%@include file="includes/Footer.jsp" %>
                </footer>
   
            </div>
        </div>

        <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/script.min.js"></script>--%>
        <script src="${pageContext.request.contextPath}/assets/js/rooms.js"></script>
        <script>
            
            //------------------------EDIT ROOM-------------------------------------------------------//
             $(document).ready(function(){
        $("#roomResult").hide();
        $("#roomResult_u").hide();
         $("#roomResult_d").hide();
        allrooms();
    });
    function allrooms(){
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "getAllRooms",
            dataType: 'json',
             
            success: function(data){
                 alert(data);
                 print3(data);
             },
             error: function(data){
                 alert(data);
             }
            
        });
    }
    function print3(value)
    {
        console.log(value);
        var print = "";
        print += " <table class='table table-striped'> <thead><tr><th>Room Number</th><th>Package ID</th>\n\
   <th>Price</th> <th>TV</th> <th>WiFi</th><th>Fridge</th> <th>Maximum Guest's(Adults + Kids)</th></tr></thead> <tbody>";

        $.each(value, function (index, r) {
            r.tv = (r.tv == true ? "Yes" : "No");
            r.wiFi = (r.wiFi == true ? "Yes" : "No");
            r.fridge = (r.fridge == true ? "Yes" : "No");
            print += "<tr id = "+r.roomNumber+"> <td> " + r.roomNumber + "</td><td>" + r.packageID + "</td><td>" + r.price + "</td><td>"
                    + r.tv + "</td><td>" + r.wiFi + "</td><td>" + r.fridge + "</td><td>" + r.guests + " <a onClick='editRooms("+r.roomNumber+")' href='#"+(-1)+"' style='margin-left: 65px;'>Edit</a>\n\
    <a onClick = 'deleteRoom("+r.roomNumber+")' href='#"+(-1)+"' style='margin-left: 65px;'>Delete</a></td><td></tr>";
        });
        print += "</tbody> </table>";
        $('#allrooms').html(print);

    }
    function editRooms(roomNo){
    //alert(roomNo);
    $("#Room_Number_u").val(roomNo);
     $("#editRoomModal").modal('show');
     
     
    //------------DELETE ROOM ----------------------------------------------------------------------// 
    }
    function deleteRoom(roomNumber){
        $("#Room_Number_d").val(roomNumber);
        $("#deleteRoomModal").modal('show');
    }
    
    $("#deleteRoom").submit(function(event){
        alert("ddd");
       event.preventDefault();
       $("#roomResult_d").empty();
       $("#roomResult_d").hide();
       deleteRoomConformation();
    });
    
    function deleteRoomConformation(){
        var roomNumber = $("#Room_Number_d").val();
        $("#roomResult_d").show();  
     $("#roomResult_d").html("<img src = 'assets/img/ajax-loader.gif'/>");
      //  alert(roomNumber);
        $.ajax({
            
            type: "GET",
            url: "deleteRoom",
            data: 'roomNumber=' + roomNumber,
             success: function(data){
                 $("#roomResult_d").html("<h3 style=color:#265a88> " + data + "</h3>")
                allrooms(); 
                 $("#roomResult_d").hide();
             },
             error: function(data){
              alert(data);
               $("#roomResult_d").hide();
             }
        });
    }
        </script>
        
        <!--------------------------delete room confirmation modal---------------------------------->
        <div class="modal fade" id="deleteRoomModal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Delete Room Confirmation</h4> 
            </div>
            <div class="main-login main-center" id="loginbox"style="width: 60%; margin: auto; margin-top: 30px;">
       <!-------------------------Edit rooms------------------------------------------------------>
       <form action="" id="deleteRoom" >
           <div class="row">
               <div class="col-md-8">Are you Sure you want to delete this room: </div>
               <div class="col-md-4"><input type="number" id="Room_Number_d"  name="Room_Number" required="required" class="form-control col-md-7 col-xs-12" readonly></div>
           </div>
            <div id="roomResult_d" style="margin-bottom: 10px"><img src="assets/img/ajax-loader.gif"/></div>
    <div class="row pad">
        <div class="form-group" style="margin-top: 10px;">
            <button type="submit" class="btn btn-primary">DELETE</button>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" class="btn btn-primary">Cancel</button>
        </div></div> 
        </form>

       
       <!--------------------------------------------------------------------------------->

            </div>
          
        </div>
    </div>
</div>
    </body>
</html>
