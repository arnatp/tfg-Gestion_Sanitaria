<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="sections/head.jsp" />
<script src="<c:url value="/resources/js/userValidations.js"/>"></script>
<jsp:include page="sections/footer.jsp" />
<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">
</head>

<body class="bg"
	style="background-image:url(<c:url value='/resources/images/background.jpg' />)">
	<c:set var="activeUserData" value="active" scope="request" />
	<jsp:include page="sections/navMenu.jsp" />
	<div class="container bg-white col-6"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<h3>
			<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
				<c:set var="hasRoleUser" value="1" scope="request" />
				<i class="fa fa-id-card-o"></i>
				<spring:message code="user.patientData" />
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
				<c:set var="hasRoleUser" value="2" scope="request" />
				<i class="fa fa-id-card-o"></i>
				<spring:message code="user.doctorData" />
			</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
				<c:set var="hasRoleUser" value="3" scope="request" />
				<i class="fa fa-user-plus"></i>
				<spring:message code="user.signUp" />
			</sec:authorize>
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="user" style="margin-top: 3%;" name="user">
			<div class="form-row m-3">
				<div class="col-md-6 col-sm-10">
					<form:input class="form-control" type="text" placeholder="0001"
						path="userId" id="userId" hidden="true" readonly="true" />
					<label for="name" class="col-form-label"> <b><spring:message
								code="user.fullName" /></b>
					</label>
					<form:input class="form-control" type="text"
						placeholder="Nombre completo" path="name" id="name"
						readonly="${hasRoleUser!=3}" name="name" required="true" />
					<div></div>
				</div>
				<div class="col-md-6 col-sm-10">
					<label for="email" class="col-form-label"> <b><spring:message
								code="user.email" /></b>
					</label>
					<form:input class="form-control" type="email"
						placeholder="patient@example.com" id="email" path="email"
						name="email" required="true" />
					<div></div>
				</div>
			</div>
			<div class="form-row m-3">
				<div class="col-md-6 col-sm-10">
					<label for="dni"> <b><spring:message code="user.DNI" /></b>
					</label>
					<form:input class="form-control" type="text"
						placeholder="12345678X" id="dni" path="dni"
						readonly="${hasRoleUser!=3}" name="dni" required="true" />
					<div></div>
				</div>
				<sec:authorize access="!hasAnyRole('ROLE_EMPLOYEE')">
					<div class="col">
						<label> <b><spring:message code="user.height" /></b>
						</label>
						<form:input class="form-control" type="number" step="0.1" min="0"
							id="height" path="height" required="true" />
					</div>
					<div class="col">
						<label> <b><spring:message code="user.weigth" /></b>
						</label>
						<form:input class="form-control" type="number" step="0.2" min="0"
							id="weigth" path="weigth" required="true" />
					</div>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
					<div class="col-md-6 col-sm-10">
						<label> <b><spring:message code="user.shift" /></b>
						</label>
						<form:input class="form-control" type="text"
							placeholder="afternoon" id="shift" path="shift" readonly="true"
							required="true" />
					</div>
				</sec:authorize>
			</div>
			<div class="form-row m-3">
				<div class="col-md-6 col-sm-10">
					<label for="mediCard"> <b><spring:message
								code="user.mediCard" /></b>
					</label>
					<form:input class="form-control" type="text"
						placeholder="12345678X" id="mediCard" path="mediCard"
						readonly="${hasRoleUser!=3}" name="mediCard" required="true" />
					<div></div>
				</div>
				<div class="col-md-6 col-sm-10">
					<label for="password1"> <b><spring:message
								code="user.password" /></b></label>
					<form:input class="form-control" type="password" id="password1"
						path="password" value="" name="password1" required="true" />
					<meter max="4" id="password-strength-meter"></meter>
					<div></div>
				</div>
			</div>
			<div class="form-row m-3">
				<div class="col">
					<label for="gender"><b><spring:message
								code="user.gender" /></b> </label>
					<c:choose>
						<c:when test="${hasRoleUser==3}">
							<form:select id="gender" class="form-control" path="gender">
								<option value="M"><spring:message code="user.gM" /></option>
								<option value="F"><spring:message code="user.gF" /></option>
								<option value="N"><spring:message code="user.gN" /></option>
							</form:select>
						</c:when>
						<c:otherwise>
							<form:input path="gender" class="form-control" readonly="true" />
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col">
					<label for="bornDate"> <b><spring:message
								code="user.birthDate" /></b>
					</label>
					<form:input class="form-control" type="date" id="bornDate"
						path="bornDate" value="${date}" readonly="${hasRoleUser!=3}"
						name="bornDate" required="true" />
					<div></div>
				</div>
				<div class="col-md-6 col-sm-10">
					<label for="password2"> <b><spring:message
								code="user.repeatPassword" /></b>
					</label>
					<form:input class="form-control" type="password" id="password2"
						path="" value="" disabled="true" name="password2" required="true" />
					<div></div>
				</div>
			</div>
			<div class="form-row m-3 d-flex justify-content-center">
				<c:choose>
					<c:when test="${hasRoleUser==3}">
						<input type="submit" id="btnAdd"
							class="btn btn-outline-success m-1"
							value="<spring:message code="user.createUser" />" />
						<input type="reset" class="btn btn-outline-secondary m-1"
							value="<spring:message code="user.clear" />" id="clean"
							name="clean" />
					</c:when>
					<c:otherwise>
						<input type="submit" id="btnAdd"
							class="btn btn-outline-success m-1"
							value="<spring:message code="user.update" />" />
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
	</div>
</body>
</html>