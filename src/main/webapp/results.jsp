<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table">
        <thead>
        <tr>
            <th>Username</th>
            <th>ID</th>
            <th>Games</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="users" scope="request" type="java.util.List"/>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.id}</td>
                <td>
                    <c:forEach var="game" items="${user.games}">
                        ${game.gameId} <br />
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>