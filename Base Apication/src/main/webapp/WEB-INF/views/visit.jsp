<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<jsp:include page="sections/head.jsp" />
<script src="<c:url value="/resources/js/visitValidations.js"/>"></script>
<jsp:include page="sections/footer.jsp" />
<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">
</head>

<body class="bg"
	style="background-image:url(<c:url value='/resources/images/background.jpg' />)">
	<jsp:include page="sections/navMenu.jsp" />
	<c:if test="${visit.completed == true}">
		<c:set var="visitCompleted" scope="page" value="true" />
	</c:if>
	<div class="container col-4 bg-white"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<h3>
			<i class="fa fa-calendar-plus-o"></i><spring:message code="visit.requestVisit" />
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="visit" style="margin-top: 3%;" id="visit"
			name="visit">
			<legend>
				<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
					<c:set var="readOnly" scope="page" value="true" />
				</sec:authorize>
			</legend>
			<div class="row">
				<div class="col-6">
					<label for="doctor" class="col-form-label"><b><spring:message code="visit.doctor" /></b></label> <select id="doctor"
						class="form-control" name="doctorDni" readonly="${readOnly}">
						<c:forEach var="doctor" items="${doctor}">
							<option value="${doctor.dni}">
								<c:out value="${doctor.name}" />
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-6">
					<label for="visitDate" class="col-form-label"><b><spring:message code="visit.date" /></b> </label>
					<form:input class="form-control" type="date" value="${date}"
						id="visitDate" path="date" readonly="${readOnly}" required="true"
						name="visitDate" />
					<div></div>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-form-label"><b><spring:message code="visit.motive" /></b></label>
				<form:textarea class="form-control col-12" id="description" rows="3"
					path="initialDescription" readonly="${readOnly}" required="true"
					name="description" />
				<div id="caracteres"></div>
			</div>

			<!-- Added Employee inputs -->
			<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
				<script src="<c:url value="/resources/js/visitValidations2.js"/>"></script>
				<input type="text" value="${patientDni}" id="" name="patientDni"
					hidden="" />
				<div class="form-group">
					<label for="description col-12"><b><spring:message code="visit.resolution" /></b></label>
					<form:textarea class="form-control col-12" id="resolution" rows="3"
						path="resolution" required="true" name="resolution"
						readonly="${visitCompleted}" />
					<div id="caracteresResoulucion"></div>
				</div>
				<div class="col-12">
					<button class="btn btn-outline-secondary col-12" type="button"
						data-toggle="collapse" data-target="#multiCollapseExample2"
						aria-expanded="false" aria-controls="multiCollapseExample2"><spring:message code="visit.prescription" /></button>
				</div>
				<br>
				<!--  -->
				<div class="collapse multi-collapse" id="multiCollapseExample2">
					<div class="col">
						<label for="visitDate" class="col-form-label"><b>
						<spring:message code="visit.prescriptionName" /></b> </label>
						<form:input class="form-control" type="text" value="" id=""
							path="prescription.medicamentName" readonly="${visitCompleted}" />
					</div>
					<div class="col-12">
						<label for="visitDate" class="col-form-label"><b><spring:message code="visit.prescriptionQuantity" /></b>
						</label>
						<form:input class="form-control" type="number" value="" id=""
							path="prescription.quantity" readonly="${visitCompleted}" />
					</div>
					<div class="col-12">
						<label for="description" class="col-form-label"><b><spring:message code="visit.prescriptionInstructions" /></b></label>
						<form:textarea class="form-control" id="" rows="3"
							path="prescription.schedule" readonly="${visitCompleted}" />
					</div>
					<br>
				</div>
				<!--  -->
			</sec:authorize>
			<div class="d-flex justify-content-center">
				<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
					<button type="submit" class="btn btn-outline-success"><spring:message code="visit.modify" /></button>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
					<button type="submit" class="btn btn-outline-success">
						<spring:message code="visit.request" /></button>
				</sec:authorize>
			</div>
	</form:form>
	</div>
<body>
</html>