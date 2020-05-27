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
			<i class="fa fa-user"></i> Datos de usuario
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="patient" style="margin-top: 3%;">
			<legend>
				<sec:authorize access="hasAnyRole('ROLE_USER')">
					<c:set var="hasRoleUser" value="true" scope="request" />
					<spring:message code="user.userData" />
				</sec:authorize>
				<sec:authorize access="!hasAnyRole('ROLE_USER')">
					<c:set var="hasRoleUser" value="false" scope="request" />
					<spring:message code="user.signUp" />
				</sec:authorize>
			</legend>
			<div class="row">
				<div class="col">
					<div class="form-group row">
						<label for="name" class="col-8 col-form-label"> <b>Nombre
								completo</b> <form:input class="form-control" type="text"
								placeholder="Arny The Critical" path="name" id="name"
								disabled="${hasRoleUser}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="bornDate" class="col-8 col-form-label"> <b>Fecha
								de nacimiento</b> <form:input class="form-control" type="date"
								value="*{date}" id="bornDate" path="bornDate"
								disabled="${hasRoleUser}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="dni" class="col-8 col-form-label"> <b>DNI</b>
							<form:input class="form-control" type="text"
								placeholder="12345678X" id="dni" path="dni"
								disabled="${hasRoleUser}" />
						</label>
					</div>
					<div class="form-group row">
						<label for="mediCard" class="col-8 col-form-label"> <b>Tarjeta
								sanitaria</b> <form:input class="form-control" type="text"
								placeholder="12345678X" id="mediCard" path="mediCard"
								disabled="${hasRoleUser}" />
						</label>
					</div>
					<div class="form-group row">
						<div class="form-group col-md-8">
							<label for="gender"><b>Sexo</b></label>
							<form:select id="gender" class="form-control" path="gender"
								disabled="${hasRoleUser}">
								<option value="M">Hombre</option>
								<option value="F">Mujer</option>
								<option value="N">Otro</option>
							</form:select>
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
					<div class="form-group row">
						<label for="" class="col-4 col-form-label"> <b>Peso (kg)</b> 
						<form:input class="form-control" type="number" step="0.01" min="0" id="height" path="height"/>
						</label>
						<label for="email" class="col-4 col-form-label"> <b>Altura (cm)</b> 
						<form:input class="form-control" type="number" step="0.01" min="0" id="weight" path="weigth"/>
						</label>
					</div>
					<div class="form-group row">
						<label for="password1" class="col-8 col-form-label"> <b>Contraseña</b>
							<form:input class="form-control" type="password" id="password1"
								path="password" />
						</label>
					</div>
					<div class="form-group row">
						<label for="password2" class="col-8 col-form-label"> <b>Repetir
								Contraseña</b> <input type="input" class="form-control"
							type="password" id="password2" disabled="${hasRoleUser}" />
						</label>
					</div>
					<button type="submit" class="btn btn-outline-success">Registrarse</button>
				</div>
			</div>
		</form:form>
	</div>
<body>
</html>