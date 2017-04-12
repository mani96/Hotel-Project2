<%-- 
    Document   : AddUser
    Created on : 14-Mar-2017, 4:53:55 PM
    Author     : manvir
--%>

<form action="" id="addUser" method="get">
    <!-------------------------User Name---------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="username">User Name<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="username"  name="username" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!---------------------------------------------First name--------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">First Name<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="firstname"  name="firstname" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!----------------------------------Last Name---------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Last Name<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="lastname"  name="lastname" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!-------------------------------------password------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">Password<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="password"  name="password" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!---------------------------------Role-------------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Role<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <select class="select_room form-control" data-style="btn-primary" id="guest" name="guest">
                    <option value="Admin">Admin</option>
                    <option value="Client">Client</option>

                </select>  
            </div>
        </div></div> 
    <!----------------------------------Phone--------------------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Phone<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="phone"  name= "phone" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!---------------------------------------submit--------------------------->
    <div class="row pad">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-warning">Reset</button>
        </div></div>  
     <div id="addUserResult" style="margin-bottom: 10px"><img src="assets/img/ajax-loader.gif"/></div>
</form>
<script>
    $("#addUser").submit(function(event){
        event.preventDefault();
        addUserProcessing();
        $("#addUserResult").empty();
    });
    
    function addUserProcessing(){
        $("#addUserResult").show();
         $("#addUserResult").html("<img src = 'assets/img/ajax-loader.gif'/>");
        var username = $("#username").val();
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var password = $("#password").val();
        var guest = $("#guest").val();
        var phone = $("#phone").val();
        
        $.ajax({
             type: "GET",
             contentType: "application/text",
             url: "addUser",
             data: "username="+username+"&firstname="+firstname+"&lastname="+lastname+"&password="+password
             +"&guest="+ guest+"&phone="+phone,
        success: function(data){
             $("#addUserResult").html("<h3 style=color:#265a88> " + data + "</h3>");
           
        },
        error: function(data){
             $("#addUserResult").html("<h3 style=color:red> " + data + "</h3>");
            
        }
        });
    }
  </script>
  