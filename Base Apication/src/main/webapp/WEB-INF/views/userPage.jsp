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

	<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
		<c:set var="hasRoleUser" value="1" scope="request" />
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
		<c:set var="hasRoleUser" value="2" scope="request" />
	</sec:authorize>

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
					<td><a href="<c:url value='/patient/visits'/>" style="text-decoration: none; color: black;">
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
					<td><a href=""
				data-toggle="modal" data-target="#modalSubscriptionForm" style="text-decoration: none; color: black;">
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
									<th>Cancelar Visita</th>
								</c:when>
								<c:otherwise>
									<th>ver visita</th>
								</c:otherwise>
							</c:choose>
						</tr>
					</thead>
					<c:if test="${visits.size()==0}">
						<tr>
							<c:choose>
								<c:when test="${hasRoleUser==1}">
									<td colspan="5">No has solicitado ninguna visita</td>
								</c:when>
								<c:otherwise>
									<td colspan="5">No tienes visitas pendientes para hoy</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
					<c:forEach var="visit" items="${visits}">
						<tr>
							<td scope="row"><c:out value=" ${visit.visitId}"></c:out></td>
							<td><c:out value=" ${visit.date}"></c:out></td>
							<td><c:choose>
									<c:when test="${hasRoleUser==1}">
										<c:out value=" ${visit.doctor.name}"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value=" ${visit.patient.name}"></c:out>
									</c:otherwise>
								</c:choose></td>
							<td><c:out value=" ${visit.initialDescription}"></c:out></td>
							<td><c:choose>
									<c:when test="${hasRoleUser==1}">
										<a class="btn btn-secondary btn-sm"
											href="<c:url value="/patient/cancelVisit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
											role="button">Cancelar</a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-secondary btn-sm"
											href="<c:url value="/doctor/visit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
											role="button">Gestionar</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</table>
			</tr>
		</table>
	</div>

<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				
			<form action="<c:url value= "/doctor/visits/findAllByDni">
            </c:url>" method="post" style="margin-top: 3%;">
            
            <div class="form-group row d-flex justify-content-center">
                <label for="dni" class="col-4 col-form-label">
                    <b>DNI/NIE</b>
                    <input class="form-control" type="text" placeholder="12345678X" name="patientDNI">
                </label>
            </div>
            
            
            <div class="d-flex justify-content-center" style="margin-bottom: 4%;">
                <button type="submit" class="btn btn-outline-success">Buscar por Dni</button>
            </div>
        </form>
				
			</div>
		</div>
	</div>

</body>

</html>