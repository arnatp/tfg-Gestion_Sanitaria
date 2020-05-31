<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<jsp:include page="sections/head.jsp" />
</head>

<body>
	<jsp:include page="sections/navMenu.jsp" />
	<h3><i class="fa fa-calendar-plus-o">Todas las visitas:</i> </h3>
	<table>
	<tr>
	<th></th>
	</tr>
	<c:forEach var="visit" items="${visits}">
	<tr>
	<td></td>
	</tr>
	</c:forEach>
	</table>
<body>
</html>