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
	<h3>
		<i class="fa fa-calendar-plus-o">Todas las visitas:</i>
	</h3>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="row">IdVisita</th>
				<th>Fecha</th>
				<th>Nombre del Paciente</th>
				<th>Descripcion de la visita</th>
				<th>ver visita</th>
			</tr>
		</thead>
		<c:forEach var="visit" items="${visits}">
			<tr>
				<td scope="row"><c:out value=" ${visit.visitId}"></c:out></td>
				<td><c:out value=" ${visit.date}"></c:out></td>
				<td><c:out value=" ${visit.patient.name}"></c:out></td>
				<td><c:out value=" ${visit.initialDescription}"></c:out></td>
				<td><a class="btn btn-secondary btn-sm"
					href="<c:url value="/doctor/visit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
					role="button">Learn more </a></td>
			</tr>
		</c:forEach>
	</table>
<body>
</html>