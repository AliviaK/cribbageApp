<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="gameScreen" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Cards: </h2>
        <div>
        <jsp:useBean id="Drawn" scope="request" class="edu.matc.deckOfCards.DrawnCards"/>
            <c:forEach var="card" items="${Drawn.cards}">
               <img src="${card.image}">
            </c:forEach>
        </div>
</div>
</body>
</html>
