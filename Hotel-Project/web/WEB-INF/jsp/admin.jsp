<%-- 
    Document   : Admin
    Created on : 13-Mar-2017, 4:40:37 PM
    Author     : manvir
--%>

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
    <div class="container">
        <div id="formAdmin" style="margin-top: 50px;">
            
        </div>
    </div>
    
    <!-------------------footer------------------------>
    <div class="footer-clean">
        <footer>
      <%@include file="includes/Footer.jsp" %>
        </footer>
		
    </div>
   
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/script.min.js"></script>
     <script src="${pageContext.request.contextPath}/assets/js/rooms.js"></script>

    </body>
</html>
