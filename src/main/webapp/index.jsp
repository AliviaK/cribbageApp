<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Cribbage Application</h2>
    <a href= 'loginAction'><button>Log In</button></a>

    <c:if test="${pageContext.request.isUserInRole('admin')}">
        <a href="search.jsp">Click here to search for users (admin only)</a>
    </c:if>


</div>

</body>
</html>