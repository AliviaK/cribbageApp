<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="gameScreen" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Your Cards: </h2>
    <form action="processCrib" method="GET" name="crib">
        <div>
            <jsp:useBean id="Player" scope="session" class="edu.matc.entity.Player"/>
            <c:forEach var="card" items="${Player.hand}" varStatus="loop">
                <input type="checkbox" id="${loop.index}" name="cardsForCrib[]" value="${card.key}">
                <label for="${loop.index}" onclick="highlightSelection(this)">
                    <img class="not-chosen" src="${card.value.image}">
                </label>
            </c:forEach>

        </div>
        <input type="submit" value="submit">Send these two cards to crib</input>
    </form>
</div>
</body>
</html>
