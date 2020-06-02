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
</head>

<body>
	<c:set var="activeUserData" value="active" scope="request" />
	<jsp:include page="sections/navMenu.jsp" />
	<div class="container"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<h3>
			<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
				<c:set var="hasRoleUser" value="1" scope="request" />
				<spring:message code="user.patientData" />
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
				<c:set var="hasRoleUser" value="2" scope="request" />
				<spring:message code="user.doctorData" />
			</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
				<c:set var="hasRoleUser" value="3" scope="request" />
				<spring:message code="user.signUp" />
			</sec:authorize>
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="user" style="margin-top: 3%;">
			<div class="row">
				<div class="col">
						 <form:input class="form-control" type="text"
								placeholder="0001" path="userId" id="userId"
								hidden="true" readonly="true"/>
					<div class="form-group row">
						<label for="name" class="col-8 col-form-label"> <b>Nombre
								completo</b> <form:input class="form-control" type="text"
								placeholder="Arny The Critical" path="name" id="name"
								readonly="${hasRoleUser!=3}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="bornDate" class="col-8 col-form-label"> <b>Fecha
								de nacimiento</b> <form:input class="form-control" type="date" id="bornDate" path="bornDate" value="${date}"
								readonly="${hasRoleUser!=3}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="dni" class="col-8 col-form-label"> <b>DNI</b>
							<form:input class="form-control" type="text"
								placeholder="12345678X" id="dni" path="dni"
								readonly="${hasRoleUser!=3}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="mediCard" class="col-8 col-form-label"> <b>Tarjeta
								sanitaria</b> <form:input class="form-control" type="text"
								placeholder="12345678X" id="mediCard" path="mediCard"
								readonly="${hasRoleUser!=3}" />
						</label>
					</div>
					<div class="form-group row">
						<div class="form-group col-md-8">
							<label for="gender"><b>Sexo</b>
								<c:choose>
				                    <c:when test="${hasRoleUser==3}">
										<form:select id="gender" class="form-control" path="gender">
											<option value="M">Hombre</option>
											<option value="F">Mujer</option>
											<option value="N">Otro</option>
										</form:select>
				                    </c:when>
				                    <c:otherwise>
			                            <form:select id="gender" class="form-control" path="gender" readonly="true">
											<option value="M">Hombre</option>
											<option value="F">Mujer</option>
											<option value="N">Otro</option>
										</form:select>
				                    </c:otherwise>
			            		</c:choose>
		            		</label>
						</div>
					</div>
				</div>
				<!-- | -->
				<div class="col">
					<div class="form-group row">
						<label for="email" class="col-8 col-form-label"> <b>Email</b>
							<form:input class="form-control" type="email"
								placeholder="patient@example.com" id="email" path="email" />
						</label>
					</div>
					<sec:authorize access="!hasAnyRole('ROLE_EMPLOYEE')">
						<div class="form-group row">
							<label class="col-4 col-form-label"> <b>Altura (cm)</b> 
								<form:input class="form-control" type="number" step="0.1" min="0" id="height" path="height"/>
							</label>
							<label class="col-4 col-form-label"> <b>Peso (kg)</b> 
								<form:input class="form-control" type="number" step="0.2" min="0" id="weigth" path="weigth"/>
							</label>
						</div>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
						<div class="form-group row">
							<label class="col-4 col-form-label"> <b>Turno</b> 
								<form:input class="form-control" type="text"
								placeholder="afternoon" id="shift" path="shift"
								readonly="true" />
							</label>
						</div>
					</sec:authorize>
					<div class="form-group row">
						<label for="password1" class="col-8 col-form-label"> <b>Contraseña</b>
							<form:input class="form-control" type="password" id="password1"
								path="password" />
						</label>
					</div>
					<c:choose>
	                    <c:when test="${hasRoleUser==3}">
	                            <input type="submit" id="btnAdd" class="btn btn-outline-success" value ="Crear Usuario"/>
	                            <input type="reset" class="btn btn-outline-secondary" value ="Limpiar"/>
	                    </c:when>
	                    <c:otherwise>
	                            <input type="submit" id="btnAdd" class="btn btn-outline-success" value ="Modificar Datos"/>
	                    </c:otherwise>
            		</c:choose>
				</div>
			</div>
		</form:form>
	</div>
<body>
</html>