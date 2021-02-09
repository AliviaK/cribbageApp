<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home" />
<c:import url="head.jsp" />
<html>
<body>
<div class="container-fluid">
    <h2>Find Friends:</h2>
    <div class="form-group">
        <form action="searchUser" method="GET">
            <label for="username">Search Type: </label>
            <input type="text" name="username" id="username"/>
            <br />
            <input type="submit" name="searchDetails" value="Enter" />
        </form>
    </div>
    <br />
    <a href = "searchUser">See All Users</a>
</div>

</body>
</html>