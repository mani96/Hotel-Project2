<%-- 
    Document   : AddUser
    Created on : 14-Mar-2017, 4:53:55 PM
    Author     : manvir
--%>

<form action="" id="addUser">
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
                <input type="text" id="firstName"  name="firstName" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!----------------------------------Last Name---------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Last Name<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="lastName"  name="lastName" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div></div> 
    <!-------------------------------------password------------------------------------->
    <div class="row pad">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">Password<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="RoomNumber"  name="password" required="required" class="form-control col-md-7 col-xs-12">
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
                    <option value="User">User</option>

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
</form>
<script>
    $("#addUser").submit(function(event){
        event.preventDefault();
        addUserProcessing();
    });
    
    function addUserProcessing(){
        var username = $("#username").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var RoomNumber = $("#RoomNumber").val();
        var guest = $("#guest").val();
        var phone = $("#phone").val();
        
        $.ajax({
             type: "GET",
             contentType: "application/text",
             url: "addUser",
             data: "username="+username+"&firstName="+firstName+"&lastName="+lastName+"&RoomNumber="+RoomNumber
             +"guest="+guest+"&phone="+phone,
        success: function(data){
            alert(data);
        },
        error: function(data){
            alert("error: "+data);
        }
        });
    }
  </script>