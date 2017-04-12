<%-- 
    Document   : user
    Created on : 11-Apr-2017, 5:00:13 PM
    Author     : manvir
--%>

<%@page import="wrappers.Search"%>
<%@page import="dao.BookingManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="wrappers.Booking"%>
<%@page import="datasource.Datasource"%>
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
        
      
        
        <%
            List<Booking> bk = new ArrayList<>();
                        try {
                            BookingManager bm = new BookingManager(Datasource.getDatasource());
                            bk = bm.get(Search.USERNAME, ((wrappers.User)session.getAttribute("user")).getUsername());
                           
                        } catch (ClassNotFoundException e) {
                            
                        }
                      if(bk.isEmpty())
                      {
                          out.print("No Bookings Found!");
                      }
                      else
                      {
                      String print = "<table class='table table-striped' style='margin-top: 50px'><thead><tr>"
                      + "<th>Booking ID</th> <th>Room Number</th><th>Username</th> <th>Start Date</th><th>End Date</th><th>Special Note</th></tr></thead> <tbody>";
                          for (int i = 0; i < bk.size(); i++) {
             
            
              print += "<tr><td>"+bk.get(i).getBooking_id()+"</td><td>"+bk.get(i).getRoom_number()+"</td><td>"+bk.get(i).getUsername()
               +"</td><td>"+bk.get(i).getStart_date()+"</td><td>"+bk.get(i).getEnd_date()+"</td><td>"+bk.get(i).getSpecial_notes()+"</td>"
                      + "<td><a href=''>Edit</a><td><a href=''>Delete</a></td></tr>";
                              }
                          print += "</tbody> </table>";
                          
                          out.println(print);
                      }
        %>
        

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

