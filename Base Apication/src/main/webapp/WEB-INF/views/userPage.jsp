<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="sections/head.jsp" />
</head>

<body>
	<jsp:include page="sections/navMenu.jsp" />

	<div class="container" style="margin-top: 3%;">
		<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
			<h2>
				<i class="fa fa-user"></i> Bienvenido
				<c:out value="${sessionScope.user.name}" />
			</h2>
			<hr style="background-color: hsl(120, 60%, 50%)">
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
			<h2>
				<i class="fa fa-user-md"></i> Bienvenido
				<c:out value="${sessionScope.user.name}" />
			</h2>
			<hr style="background-color: hsl(120, 60%, 50%)">
		</sec:authorize>
		<table class="table" style="margin-top: 5%;">
			<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
				<tr>
					<td><a href="#" style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-history fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;">Ver historial de visitas</b>
							</div>
					</a></td>
					<td><a href="<c:url value='/patient/visit'/>"
						style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-calendar-plus-o fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;">Solicitar nueva visita</b>
							</div>
					</a></td>
				</tr>
			</sec:authorize>
			<!-- ROLE_EMPLOYEE -->
			<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
				<tr>
					<td><a href="<c:url value='/doctor/visits'/>"
						style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-history fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;">Ver historial de visitas</b>
							</div>
					</a></td>
					<td><a href="#" style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-search fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;">Buscar historial de paciente por
									DNI</b>
							</div>
					</a></td>
				</tr>
			</sec:authorize>
			<tr>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="row">IdVisita</th>
							<th>Fecha</th>
							<th>Nombre del Paciente</th>
							<th>Descripcion de la visita</th>
							<th>Ver visita</th>
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
								role="button">Gestionar</a></td>
						</tr>
					</c:forEach>
				</table>
			</tr>
		</table>
	</div>

</body>

</html>