<%-- 
    Document   : navigation
    Created on : 13-Mar-2017, 3:58:00 PM
    Author     : manvir
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top opaque-navbar">
    <div class="container ">
        <div class="navbar-header">
            <a class="navbar-brand navbar-link" href="#"> </a>
            <button class="navbar-toggle collapsed toggle-animated" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
        </div>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav">
                <li role="presentation"><a href="index">Home. </a></li>
               
                <li role="presentation"><a href="#contact">Contact</a></li>
                
                <c:if test="${sessionScope.user == null}">
                    
                    <li role="presentation"><a href="#" data-toggle="modal"   data-target="#login">Login</a></li>
                </c:if>
                
                    <c:if test="${sessionScope.user != null}">
                        <li role="presentation"><a href="logout">Logout</a></li>
                        <c:if test="${sessionScope.user.isAdmin()}">
                            <li role="presentation"><a href="redirectAdmin">Access Admin Panel - ${sessionScope.user.getFirstName()}</a></li>
                        </c:if>
                            <c:if test="${sessionScope.user.isAdmin() == false}">
                            <li role="presentation"><a href="redirectUser">Access User Panel - ${sessionScope.user.getFirstName()}</a></li>
                        </c:if>
                              
                    </c:if>
            </ul>
        </div>
    </div>
</nav>
<div id="home">
<div id="slider">	
    <div class="carousel slide" data-ride="carousel" id="carousel-1">
        <div class="carousel-inner" role="listbox">
            <div class="item active"><img src="assets/img/1.jpg" alt="Slide Image"></div>
            <div class="item"><img src="assets/img/2.jpg" alt="Slide Image"></div>
            <div class="item"><img src="assets/img/3.jpg" alt="Slide Image"></div>
            <div class="item"><img src="assets/img/4.jpg" alt="Slide Image"></div>
        </div>
        <div><a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i><span class="sr-only">Previous</span></a>
            <a class="right carousel-control" href="#carousel-1" role="button" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i><span class="sr-only">Next</span></a>
        </div>
        <ol class="carousel-indicators">
            <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-1" data-slide-to="1"></li>
            <li data-target="#carousel-1" data-slide-to="2"></li>
            <li data-target="#carousel-1" data-slide-to="2"></li>
        </ol>
    </div>
</div>
    </div>
