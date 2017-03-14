<%-- 
    Document   : Login
    Created on : 13-Mar-2017, 4:46:45 PM
    Author     : manvir
--%>

<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">${resname}</h4> 
            </div>
            <div class="main-login main-center" style="width: 60%; margin: auto">
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
                            <a id="btn-fblogin" href="fblogin.html" class="btn btn-primary">Login with Facebook</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                Don't have an account! 
                                <a href="signUp.html" >
                                    Sign Up Here
                                </a>
                            </div>
                        </div>
                    </div>  
                </form>

            </div>
        </div>
    </div>
</div>
