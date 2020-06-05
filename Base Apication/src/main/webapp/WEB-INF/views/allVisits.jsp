<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<jsp:include page="sections/head.jsp" />
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
		<br>
		<h2>
			<i class="fa fa-calendar"></i>
			<spring:message code="allVisits.allVisits" />
		</h2>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="row"><spring:message code="allVisits.idVisit" /></th>
						<th><spring:message code="allVisits.date" /></th>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<th><spring:message code="allVisits.doctorName" /></th>
							</c:when>
							<c:otherwise>
								<th><spring:message code="allVisits.patientName" /></th>
							</c:otherwise>
						</c:choose>
						<th><spring:message code="allVisits.description" /></th>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<th><spring:message code="allVisits.resolution" /></th>
							</c:when>
							<c:otherwise>
								<th><spring:message code="allVisits.resolution" /></th>
								<th><spring:message code="allVisits.viewVisit" /></th>
							</c:otherwise>
						</c:choose>
					</tr>
				</thead>
				<c:if test="${visits.size()==0}">
					<tr>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
								<td colspan="5"><spring:message
										code="allVisits.notVisitedYet" /></td>
							</c:when>
							<c:otherwise>
								<td colspan="5"><spring:message
										code="allVisits.notAttendedYet" /></td>
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
						<td class="text-truncate" style="max-width: 250px;"><c:out
								value=" ${visit.initialDescription}"></c:out></td>
						<td class="text-truncate" style="max-width: 250px;"><c:out
								value=" ${visit.resolution}"></c:out></td>
						<c:choose>
							<c:when test="${hasRoleUser==1}">
							</c:when>
							<c:otherwise>
								<td><a class="btn btn-secondary btn-sm"
									href="<c:url value="/doctor/visit"><c:param name="visitId" value ="${visit.visitId}"/></c:url>"
									role="button"><spring:message code="allVisits.gestion" /></a>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${visits.size()!=0}">
				<c:choose>
					<c:when test="${hasRoleUser==1}">
						<a class="btn btn-secondary btn-sm" role="button"
							href="<c:url value="printHistory"></c:url>"
							style="float: right; margin-right: 1.5%;"><i
							class="fa fa-print"></i> <spring:message code="allVisits.pdf" /></a>
					</c:when>
					<c:otherwise>
						<c:if test="${patientDni != null}">
							<a class="btn btn-secondary btn-sm" role="button"
								href="<c:url value="printHistory"><c:param name="patientDNI" value="${patientDni}"/></c:url>"
								style="float: right; margin-right: 1.5%;"><i
								class="fa fa-print"></i> <spring:message code="allVisits.pdf" /></a>
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</div>
<body>
</html>
