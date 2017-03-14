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
            <div class="col-md-6 col-6" style="margin-top: 30px;">
                <div id="tabs">
                    <div class="tab-content">
                        <!-------------------------------Add users--------------------------------->
                        <div id="user" class="tab-pane fade in active">
                            <%@include file="includes/AddUser.jsp" %>
                        </div>
                        <!--------------------------------Add rooms form-------------------------->
                        <div id="addRooms" class="tab-pane fade">
                            <%@include file="includes/AddRoom.jsp" %>
                        </div>
                        <!------------------------------------Rooms list for edit or delete------------------>
                        <div id="rooms" class="tab-pane fade">
                            <h3>Rooms</h3>
                            <p>ALL SEXY ROOMS HERE</p>
                        </div>


                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!-------------------footer------------------------>
            <%@include file="includes/Login.jsp" %>
            <div class="footer-clean">
                <footer>
                    <%@include file="includes/Footer.jsp" %>
                </footer>

            </div>
        </div>

        <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/script.min.js"></script>--%>
        <script src="${pageContext.request.contextPath}/assets/js/rooms.js"></script>

    </body>
</html>
