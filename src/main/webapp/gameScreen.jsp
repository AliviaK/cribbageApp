<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="gameScreen" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Cards: </h2>
    <table class="table">
        <thead>
        <tr>
            <th>Deck</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="Deck" scope="request" class="edu.matc.deckOfCards.Deck"/>

            <tr>
                <td>${Deck}</td>
            </tr>

        </tbody>
    </table>
</div>
</body>
</html>
