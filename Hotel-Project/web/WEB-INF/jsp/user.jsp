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

        <div class="container">
            <table class='table table-striped container' style='margin-top: 50px'>
                <thead>
                    <tr>
                        <th>Booking ID</th>
                        <th>Room Number</th>
                        <th>Username</th> 
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Special Note</th>
                    </tr>
                </thead> 
                <tbody>
                    <%
                        List<Booking> bk = new ArrayList();
                        try {
                            BookingManager bm = new BookingManager(Datasource.getDatasource());
                            bk = bm.get(Search.USERNAME, ((wrappers.User) session.getAttribute("user")).getUsername());

                        } catch (ClassNotFoundException e) {

                        }
                        if (bk.isEmpty()) {
                            out.print("No Bookings Found!");
                        } else {

                for (int i = 0; i < bk.size(); i++) {%>
                    <tr>
                        <td><%=bk.get(i).getBooking_id()%> </td>
                        <td><%=bk.get(i).getRoom_number()%></td>
                        <td><%=bk.get(i).getUsername()%></td>
                        <td><%=bk.get(i).getStart_date()%></td>
                        <td><%=bk.get(i).getEnd_date()%></td>
                        <td><%=bk.get(i).getSpecial_notes()%></td>
                        <td><a href="#-1" data-toggle="modal" data-target="#editUserBooking" onclick="test4(<%=bk.get(i).getBooking_id()%>,<%=bk.get(i).getRoom_number()%>, '<%=bk.get(i).getUsername()%>', '<%=bk.get(i).getStart_date()%>', '<%=bk.get(i).getEnd_date()%>', '<%=bk.get(i).getSpecial_notes()%>' )  ">Edit</a></td>
                        
                    </tr>


                    <%

                            }
                        }
                    %>
                </tbody> </table>
        </div>
        <!-------------------footer------------------------>
         <%@include file="includes/EditUserBooking.jsp" %>
        <div class="footer-clean">
            <footer>
                <%@include file="includes/Footer.jsp" %>
            </footer>

        </div>
    </div>


    <script src="${pageContext.request.contextPath}/assets/js/rooms.js"></script>
    <script src = "${pageContext.request.contextPath}/assets/js/Filterable-Gallery.js"></script>
    <script>
                            function test4(bookId, roomNumber , userName , sdate , edate, snotes) {
                              //  alert(roomNumber + " " + bookId + "sdate" + sdate + "edate" + edate + "snotes" + snotes);
                                $("#booking_id").val(bookId);
                                $("#room_number").val(roomNumber);
                                $("#username_b").val(userName);
                                $("#start_date").val(sdate);
                                $("#end_date").val(edate);
                                $("#special_notes").val(snotes);
                            }
    </script>
    
   
</body>

</html>

