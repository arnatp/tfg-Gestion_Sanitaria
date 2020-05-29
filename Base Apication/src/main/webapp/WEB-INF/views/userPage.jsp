<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="sections/head.jsp" />
</head>

<body>
    <jsp:include page="sections/navMenu.jsp" />
        
        <div class="col-12" style="margin-top: 3%;">
            <h1>Bienveido: <c:out value="${sessionScope.user.name}"/></h1>
            <hr>
        </div>
</body>

</html>