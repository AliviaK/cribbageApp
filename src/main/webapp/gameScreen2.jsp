<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="gameScreen2" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Select Card to Play: </h2>

    <div>
        <h3>Played Cards:</h3>
        <jsp:useBean id="playerHands" scope="request" class="edu.matc.entity.Player"/>
        <c:forEach var="card" items="${playerHands.playedCards}" varStatus="loop">
                <img class="not-chosen" src="${card.value.image}" alt="Card with value of ${card.key}">
        </c:forEach>
    </div>

    <form action="addAllCards" method="get">
        <div>
            <jsp:useBean id="playerHands" scope="request" class="edu.matc.entity.Player"/>
            <c:forEach var="card" items="${playerHands.hand}" varStatus="loop">
                <input type="radio" id="${loop.index}" name="cardToPlay" value="${card.key}">
                <label for="${loop.index}">
                    <img class="not-chosen" src="${card.value.image}" alt="Card with value of ${card.key}">
                </label>
            </c:forEach>
        </div>
        <input type="submit" value="submit">Play card
    </form>
</div>
</body>
</html>
