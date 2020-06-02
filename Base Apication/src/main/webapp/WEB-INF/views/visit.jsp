<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<jsp:include page="sections/head.jsp" />
<script type="text/javascript">
function inici() {
	submitBothForms = function(){
	    document.getElementById("form1").submit();
	    document.getElementById("form2").submit();
	}
}
window.onload = inici;
</script>
</head>

<body>
	<jsp:include page="sections/navMenu.jsp" />
	<div class="container col-4"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<h3>
			<i class="fa fa-calendar-plus-o"></i> Solicitar nueva visita
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="visit" style="margin-top: 3%;" id="form1">
			<div class="row">
				<div class="col">
					<div class="form-group row">
						<div class="form-group col-6">
							<label for="doctor"><b>Doctor</b></label> <select id="doctor"
								class="form-control" name="doctorDni">
								<c:forEach var="doctor" items="${doctor}">
									<option value="${doctor.dni}">
										<c:out value="${doctor.name}" />
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-6">
							<label for="visitDate" class="col-form-label"><b>Fecha
									de visita</b> </label>
							<form:input class="form-control" type="date" value="2020-06-01"
								id="date" path="date" />
						</div>
					</div>
					<div class="form-group">
						<label for="description "><b>Motivo de visita</b></label>
						<form:textarea class="form-control col-12" id="description"
							rows="3" path="initialDescription" />
					</div>

					<!-- Added Employee inputs -->
					<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
						<div class="form-group">
							<label for="description col-12"><b>Resolucion de la
									visita</b></label>
							<form:textarea class="form-control col-12" id="description"
								rows="3" path="resolution" />
						</div>
						<div class="col-12">
							<a href="" class="btn btn-outline-secondary col-12"
								data-toggle="modal" data-target="#modalSubscriptionForm">Crear
								Receta</a>
						</div>
						<br>
					</sec:authorize>
					<div class="d-flex justify-content-center">

						<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
							<button type="button" class="btn btn-outline-success" onclick="submitBothForms()"> Modificar </button>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
							<button type="submit" class="btn btn-outline-success"> Solicitar </button>
						</sec:authorize>

					</div>
				</div>
			</div>
		</form:form>
	</div>

	<!-- Modal for prescription creation -->
	<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form:form modelAttribute="prescription" style="margin-top: 3%;" id="form2">
					<div class="col-12">
						<label for="visitDate" class="col-form-label"><b>Nombre
								del medicamento:</b> </label>
						<form:input class="form-control" type="text" value="" id=""
							path="medicamentName" />
					</div>
					<div class="col-12">
						<label for="visitDate" class="col-form-label"><b>Nombre
								del medicamento:</b> </label>
						<form:input class="form-control" type="number" value="" id=""
							path="quantity" />
					</div>
					<div class="col-12">
						<label for="description" class="col-form-label"><b>Pauta:</b></label>
						<form:textarea class="form-control" id="" rows="3" path="schedule" />
					</div>
					<br>
					<div class="col-12 d-flex justify-content-center">
						<button class="btn btn-outline-success" data-dismiss="modal">Crear
							Receta</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- End of prescription creation modal -->
<body>
</html>