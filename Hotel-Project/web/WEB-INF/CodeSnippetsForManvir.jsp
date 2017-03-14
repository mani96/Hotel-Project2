<%--
    Snippet for putting where login button is to change according to the login status
    Put this snippet where you want the login button to change
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user == null }">
        <c:redirect url="index" />
    </c:when>
    <c:otherwise>
        <c:out value="<li role=\"presentation\"><a href=\"logout\" data-toggle=\"modal\" data-target=\"#logout\">Logout</a></li>" />
    </c:otherwise>
</c:choose>