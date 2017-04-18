<%-- 
    Document   : Login
    Created on : 13-Mar-2017, 4:46:45 PM
    Author     : manvir
onClick="$('#loginbox').hide(); $('#signupbox').show()"
--%>

<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">${resname}</h4> 
            </div>
            <div class="main-login main-center" id="loginbox"style="width: 60%; margin: auto">
                <form name = "loginForm" class="form-horizontal"  method="post" action="${pageContext.request.contextPath}/login.html">
                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="username" id="username"  placeholder="Enter yourUsername" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group" >
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" >
                        <div class="col-sm-12 controls">
                            <input type="submit" id="btn-login" href="${pageContext.request.contextPath}/login.html" class="btn btn-success" value="Login" />
                           
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                Don't have an account! 
                                <a href="#" onclick="$('#loginbox').hide(); $('#sign').show()">
                                    Sign Up Here
                                </a>
                            </div>
                        </div>
                    </div>  
                </form>

            </div>
            <!-----------SignUp form-------------------->
            <div id="sign" style="display: none">
                <div class="text-center" style="width: 60%; margin: auto" >
                    <div class="form-container">
                        <div class="image-holder"></div>
                        <form id = "signUp" action="addUser" method="get">
                            <h2 class="text-center"><strong>Create</strong> an account.</h2>
                            <div class="form-group">
                                <input class="form-control" type="text" name="username" id="username_u" placeholder="username">
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" name="firstname" id="firstname" placeholder="First Name">
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" name="lastname" id="lastname" placeholder="Last Name">
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="password" name="password" id="password_u" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <select class="select_room form-control" data-style="btn-primary" name="guest" id="guest">
                    <option value="Client">Client</option>
                </select>
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" name="phone" id="phone" placeholder="Phone Number">
                            </div>
                     <div id="addUserResult" style="margin-bottom: 10px"><img src="assets/img/ajax-loader.gif"/></div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-block" type="submit">Sign Up</button>
                            </div><a href="#" class="already" onclick="$('#sign').hide(); $('#loginbox').show()">You already have an account? Login here.</a></form>
                    </div>
                </div>
            </div>
            <!-------------------------------->
        </div>
    </div>
</div>
<script>
    $("#signUp").submit(function(event){
        event.preventDefault();
        addUserProcessing();
        $("#addUserResult").empty();
    });
    
    function addUserProcessing(){
        $("#addUserResult").show();
         $("#addUserResult").html("<img src = 'assets/img/ajax-loader.gif'/>");
        var username = $("#username_u").val();
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var password = $("#password_u").val();
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