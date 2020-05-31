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
	<div class="container col-4"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<h3>
			<i class="fa fa-calendar-plus-o"></i> Solicitar nueva visita
		</h3>
		<hr style="background-color: hsl(120, 60%, 50%)">
		<form:form modelAttribute="visit" style="margin-top: 3%;">
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
							<form:input class="form-control" type="date" value="2011-08-19"
								id="date" path="date" />
						</div>
					</div>
					<div class="form-group">
						<label for="description col-12"><b>Motivo de visita</b></label>
						<form:textarea class="form-control col-12" id="description"
							rows="3" path="initialDescription" />
					</div>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-outline-success">Solicitar</button>
					</div>
				</div>
				<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
					<div class="form-group">
						<label for="description col-12"><b>Resolucion de la
								visita</b></label>
						<form:textarea class="form-control col-12" id="description"
							rows="3" path="resolution" />
					</div>
					<div class="col-6">
						<label for="visitDate" class="col-form-label"><b>Fecha
								de visita</b> </label>
						<form:checkbox class="form-control" id="done" path="completed" />
						<a href="" class="btn btn-default btn-rounded mb-4"
				data-toggle="modal" data-target="#modalSubscriptionForm">Launch
				Modal Subscription Form</a>
					</div>
				</sec:authorize>
			</div>
		</form:form>
	</div>
	<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Subscribe</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body mx-3">
					<div class="md-form mb-5">
						<i class="fas fa-user prefix grey-text"></i> <input type="text"
							id="form3" class="form-control validate"> <label
							data-error="wrong" data-success="right" for="form3">Your
							name</label>
					</div>

					<div class="md-form mb-4">
						<i class="fas fa-envelope prefix grey-text"></i> <input
							type="email" id="form2" class="form-control validate"> <label
							data-error="wrong" data-success="right" for="form2">Your
							email</label>
					</div>

				</div>
				<div class="modal-footer d-flex justify-content-center">
					<button class="btn btn-indigo">
						Send <i class="fas fa-paper-plane-o ml-1"></i>
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="text-center">
		<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">Subscribe</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <input type="text"
								id="form3" class="form-control validate"> <label
								data-error="wrong" data-success="right" for="form3">Your
								name</label>
						</div>

						<div class="md-form mb-4">
							<i class="fas fa-envelope prefix grey-text"></i> <input
								type="email" id="form2" class="form-control validate"> <label
								data-error="wrong" data-success="right" for="form2">Your
								email</label>
						</div>

					</div>
					<div class="modal-footer d-flex justify-content-center">
						<button class="btn btn-indigo">
							Send <i class="fas fa-paper-plane-o ml-1"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="text-center">
			
		</div>
	</div>
<body>
</html>