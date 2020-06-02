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
	<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
		<c:set var="hasRoleUser" value="1" scope="request" />
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
		<c:set var="hasRoleUser" value="2" scope="request" />
	</sec:authorize>
	<div class="container">
	<br>
	<h3>
		<i class="fa fa-calendar-plus-o">Todas las visitas:</i>
	</h3>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="row">IdVisita</th>
					<th>Fecha</th>
					<c:choose>
		                <c:when test="${hasRoleUser==1}">
		                	<th>Nombre del Doctor</th>
		                </c:when>
		                <c:otherwise>
		                	<th>Nombre del Paciente</th>
		                </c:otherwise>
	                </c:choose>
					<th>Descripcion de la visita</th>
					<c:choose>
		                <c:when test="${hasRoleUser==1}">
		                	<th>Resoulción de visita</th>
		                </c:when>
		                <c:otherwise>
		                	<th>Resoulción de visita</th>
		                	<th>ver visita</th>
		                </c:otherwise>
	                </c:choose>
				</tr>
			</thead>
			<c:if test="${visits.size()==0}">
						<tr>
							<c:choose>
								<c:when test="${hasRoleUser==1}">
									<td colspan="5">No te ha visitado ningún doctor</td>
								</c:when>
								<c:otherwise>
									<td colspan="5">Nunca has atendido a ningún paciente</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
			<c:forEach var="visit" items="${visits}">
				<tr>
					<td scope="row"><c:out value=" ${visit.visitId}"></c:out></td>
					<td><c:out value=" ${visit.date}"></c:out></td>
					<td>
					<c:choose>
		                <c:when test="${hasRoleUser==1}">
		                	<c:out value=" ${visit.doctor.name}"></c:out>
		                </c:when>
		                <c:otherwise>
		                	<c:out value=" ${visit.patient.name}"></c:out>
		                </c:otherwise>
	                </c:choose>
					</td>
					<td><c:out value=" ${visit.initialDescription}"></c:out></td>
					<td><c:out value=" ${visit.resolution}"></c:out></td>
					<td>
					<c:choose>
		                <c:when test="${hasRoleUser==1}">
		                </c:when>
		                <c:otherwise>
		                	<a class="btn btn-secondary btn-sm"
							href="<c:url value="/doctor/visit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
							role="button">Gestionar</a>
		                </c:otherwise>
	                </c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<body>
</html>