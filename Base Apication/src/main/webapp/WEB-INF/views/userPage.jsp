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
<script src="<c:url value="/resources/js/cancelVisit.js"/>"></script>
<jsp:include page="sections/footer.jsp" />
<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">
</head>

<body>
	<jsp:include page="sections/navMenu.jsp" />

	<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
		<c:set var="hasRoleUser" value="1" scope="request" />
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
		<c:set var="hasRoleUser" value="2" scope="request" />
	</sec:authorize>

	<div class="container bg-white" style="margin-top: 3%;">
		<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
			<h2>
				<i class="fa fa-user"></i>
				<spring:message code="userPage.welcome" />
				<c:out value="${sessionScope.user.name}" />
			</h2>
			<hr style="background-color: hsl(120, 60%, 50%)">
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
			<h2>
				<i class="fa fa-user-md"></i>
				<spring:message code="userPage.welcome" />
				<c:out value="${sessionScope.user.name}" />
			</h2>
			<hr style="background-color: hsl(120, 60%, 50%)">
		</sec:authorize>
		<table class="table" style="margin-top: 5%;">
			<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
				<tr>
					<td><a href="<c:url value='/patient/visits'/>"
						style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-history fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;"><spring:message
										code="userPage.seeHistory" /></b>
							</div>
					</a></td>
					<td><a href="<c:url value='/patient/visit'/>"
						style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-calendar-plus-o fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;"><spring:message
										code="userPage.newVisit" /></b>
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
								<b style="margin-top: 1%;"><spring:message
										code="userPage.seeHistory" /></b>
							</div>
					</a></td>
					<td><a href="" data-toggle="modal"
						data-target="#modalSubscriptionForm"
						style="text-decoration: none; color: black;">
							<div class="d-flex justify-content-center">
								<i class="fa fa-search fa-3x"></i>
							</div>
							<div class="d-flex justify-content-center">
								<b style="margin-top: 1%;"><spring:message
										code="userPage.findByDNI" /></b>
							</div>
					</a></td>
				</tr>
			</sec:authorize>
		</table>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="row"><spring:message
								code="userPage.idVisit" /></th>
						<th><spring:message code="userPage.date" /></th>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<th><spring:message code="userPage.doctorName" /></th>
							</c:when>
							<c:otherwise>
								<th><spring:message code="userPage.patientName" /></th>
							</c:otherwise>
						</c:choose>
						<th><spring:message code="userPage.visitDescr" /></th>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<th><spring:message code="userPage.cancelVisit" /></th>
							</c:when>
							<c:otherwise>
								<th><spring:message code="userPage.seeVisit" /></th>
							</c:otherwise>
						</c:choose>
					</tr>
				</thead>
				<c:if test="${visits.size()==0}">
					<tr>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<td colspan="5"><spring:message code="userPage.anyVisit" /></td>
							</c:when>
							<c:otherwise>
								<td colspan="5"><spring:message code="userPage.todayVisit" /></td>
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
						<td class="d-inline-block text-truncate" style="max-width: 550px;">
								<c:out value=" ${visit.initialDescription}"></c:out>
							</td>
						<td><c:choose>
								<c:when test="${hasRoleUser==1}">
									<a class="cancelVisit btn btn-secondary btn-sm"
										href="<c:url value="/patient/cancelVisit">
											<c:param name="visitId" value ="${visit.visitId}"/></c:url>"
										role="button" id="cancelVisit"><spring:message
											code="userPage.cancel" /></a>
								</c:when>
								<c:otherwise>
									<a class="btn btn-secondary btn-sm"
										href="<c:url value="/doctor/visit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
										role="button"><spring:message code="userPage.manage" /></a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<form
					action="<c:url value= "/doctor/visits/findAllByDni">
            </c:url>"
					method="post" style="margin-top: 3%;">

					<div class="form-group row d-flex justify-content-center">
						<label for="dni" class="col-4 col-form-label"> <b>DNI/NIE</b>
							<input class="form-control" type="text" placeholder="12345678X"
							name="patientDNI">
						</label>
					</div>


					<div class="d-flex justify-content-center"
						style="margin-bottom: 4%;">
						<button type="submit" class="btn btn-outline-success">
							<spring:message code="userPage.findDNI" />
						</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>

</html>