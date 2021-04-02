<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid text-center">
    <div class="jumbotron jumbotron-fluid">
        <div class="container p-3">
            <h1 class="display-4">Online Cribbage</h1>
        </div>
    </div>
    <a href='loginAction'><button class="button">Log In</button></a>

    <c:if test="${pageContext.request.isUserInRole('admin')}">
        <a href="search.jsp">Click here to search for users (admin only)</a>
    </c:if>

    <a href='playGame'>Let's gooooooooo</a>
</div>

</body>
</html>