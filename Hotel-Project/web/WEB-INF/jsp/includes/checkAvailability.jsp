<%-- 
    Document   : checkAvailability
    Created on : 13-Mar-2017, 3:53:59 PM
    Author     : manvir
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid well" style="padding-bottom: 100px;">
    <div class="container" >
        <div class="checkForm" >
            <div class="row text-center">
                <form id="checkAv" action="" method="post">
                    <div class="col-3 col-md-3">
                        <div class="input-group date mg-check-in">
                            <div class="input-group date mg-check-in">

                                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                <input type="text" class="form-control" name="checkin" id="datepicker1" required placeholder="Check-In Date">
                            </div>
                        </div>

                    </div>
                    <div class="col-3 col-md-3">
                        <div class="input-group date mg-check-in">
                            <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                            <input type="text" name="checkout" class="form-control" required id="datepicker2" placeholder="Check-Out Date">
                        </div>

                    </div>
                    <div class="col-3 col-md-3">
                        <select class="select_room form-control" data-style="btn-primary" id="guests" name="guests" onchange="roomType(this.value)" >
                            <option value="1">Single-Bed Room</option>
                            <option value="2">Double-Bed Room</option>
                            <option value="3">Triple-Bed Room</option>
                        </select>
                    </div>
                    <div class="col-3 col-md-3">
                        <div class="row">
                            <div class="col-6 col-md-6"><p>Adults Per Room</p></div>
                            <div class="col-6 col-md-6">
                                <div id="Sadults">

                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 10px;">
                            <div class="col-6 col-md-6"><p>Kids Per Room</p></div>
                            <div class="col-6 col-md-6">
                                <div id="Skids">

                                </div></div>
                        </div>
                    </div>
                    <c:if test="${sessionScope.user.isAdmin() == false}">
                    <div class="row">
                        <button type="submit" class="btn btn-primary">Check Availability</button><br><br>
                    </div>
                </c:if>
                    <c:if test="${sessionScope.user.isAdmin() == true}">
                    <div class="row">
                        <h2 style="color: red">*Admin cannot book the romm</h2>
                    </div>
                </c:if>
                   
                    
                    <div class="row">

                        <img src="assets/img/ajax-loader.gif" id="loader" />
                    </div>

                </form>
            </div>

        </div>
        <div id="result">

        </div>
    </div>

</div>
<script>
    $(document).ready(function () {
        $("#loader").hide();
    });
    $("#checkAv").submit(function (event) {
        event.preventDefault();
        $("#result").html("");
        $("#loader").show();
        test();
    });
    function test() {

        var checkin = $("#datepicker1").val();
        var checkout = $("#datepicker2").val();
        var guests = $("#guests").val();
        // alert(guests);

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "${home}availability",

            dataType: 'json',
            data: "checkin=" + checkin + "&checkout=" + checkout + "&guests=" + guests,

            success: function (data) {
                print2(data);
            },
            error: function (e) {
                alert("error" + e);
                $("#loader").hide();
            }
        });

    }

    function print2(value)
    {

        $("#loader").hide();

        console.log(value);
        var print = "";
        print += " <table class='table table-striped'> <thead><tr><th>Room Number</th><th>Package ID</th>\n\
   <th>Price</th> <th>TV</th> <th>WiFi</th><th>Fridge</th> <th>Maximum Guest's(Adults + Kids)</th></tr></thead> <tbody>";

        $.each(value, function (index, r) {
            r.tv = (r.tv == true ? "Yes" : "No");
            r.wiFi = (r.wiFi == true ? "Yes" : "No");
            r.fridge = (r.fridge == true ? "Yes" : "No");
            print += "<tr id = "+r.roomNumber+"> <td> " + r.roomNumber + "</td><td>" + r.packageID + "</td><td>" + r.price + "</td><td>"
                    + r.tv + "</td><td>" + r.wiFi + "</td><td>" + r.fridge + "</td><td>" + r.guests + " <a onClick='Book("+r.roomNumber+")' href='#"+(-1)+"' style='margin-left: 65px;'>Book</a>\n\
    <div style='display: none' class='bookingResult' id='bookResult"+r.roomNumber+"'> </div></td><td></tr>";
        });
        print += "</tbody> </table>";
        $('#result').html(print);

    }


</script>
