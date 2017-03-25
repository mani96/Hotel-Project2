<%-- 
    Document   : checkAvailability
    Created on : 13-Mar-2017, 3:53:59 PM
    Author     : manvir
--%>

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
                    <div class="row">
                        <button type="submit" class="btn btn-primary">Check Availability</button><br><br>
                    </div>
                    <div class="row">

                        <img src="assets/img/ajax-loader.gif" id="loader" />
                    </div>

                </form>
            </div>

        </div>
        <div id="result">
            RESULT
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

            dataType: 'text',
            data: "checkin=" + checkin + "&checkout=" + checkout + "&guests=" + guests,

            success: function (data) {
                printing(data);
            },
            error: function (e) {
                alert("error" + e);
            }
        });

    }
    function printing(value) {
        $("#loader").hide();
        var arr;
        var table = "table table-striped";
        var k = 0;
        var print = "";
        arr = JSON.parse(value);
        print += " <table class='table table-striped'> <thead><tr><th>Room Number</th><th>Package ID</th>\n\
   <th>Maximum Guest's(Adults + Kids)</th> <th>Price</th> <th>WiFi</th><th>Fridge</th> <th>TV</th></tr></thead> <tbody>";
        for (var i = 0; i < arr.length; i++) {
            var obj = arr[i];
            for (var key in obj) {

                k++;
                if (k == 1) {
                    print += "<tr>"
                    //alert(k + "<br> - " + key + ": " + value);

                }
                var value = obj[key];
               if(value ==  true || value == false){
                // value = (value == true ? 'Yes' : 'No');
                  
               }
                print += ("<td>" +  value + "</td>");
                if (k == 7) {
                    print += "</tr>";
                    // alert(k + "<br> - " + key + ": " + value);
                    k = 0;
                }

            }
        }
        print += "</tbody> </table>";
        $('#result').html(print);
    }

</script>
