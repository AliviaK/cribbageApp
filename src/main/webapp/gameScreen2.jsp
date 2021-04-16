<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="gameScreen2" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Your Cards: </h2>

        <div>
            <jsp:useBean id="cardsAfterCrib" scope="request" class="edu.matc.entity.Player"/>
            <c:forEach var="card" items="${cardsAfterCrib.hand}">
                <img class="not-chosen" src="${card.value.image}">
            </c:forEach>
        </div>

</div>
</body>
</html>
