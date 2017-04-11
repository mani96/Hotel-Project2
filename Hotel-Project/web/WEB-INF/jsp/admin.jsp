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
             $(document).ready(function(){
        $("#roomResult").hide();
        $("#roomResult_u").hide();
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
    <div style='display: none' class='bookingResult' id='bookResult"+r.roomNumber+"'> </div></td><td></tr>";
        });
        print += "</tbody> </table>";
        $('#allrooms').html(print);

    }
    function editRooms(roomNo){
    //alert(roomNo);
    $("#Room_Number_u").val(roomNo);
     $("#editRoomModal").modal('show');
     
    }
        </script>
    </body>
</html>
