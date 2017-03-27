<%-- 
    Document   : index
    Created on : 13-Mar-2017, 4:43:22 PM
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
        <!------------login-form------------------>
        <%@include file="includes/Login.jsp" %>
        <!-----------------------------------------check form-------------------------------->
        <%@include file="includes/checkAvailability.jsp" %>
        <!---------------------------------Gallery + Map------------------------------------------------------>
        <div class="container-fluid">
            <%@include file="includes/gallery.jsp" %>

            <!-------------------footer------------------------>
            <div class="footer-clean">
                <footer>
                    <%@include file="includes/Footer.jsp" %>
                </footer>

            </div>
        </div>


        <script src="${pageContext.request.contextPath}/assets/js/rooms.js"></script>
<script src = "${pageContext.request.contextPath}/assets/js/Filterable-Gallery.js"></script>

    </body>

</html>
