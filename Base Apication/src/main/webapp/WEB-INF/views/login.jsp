<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="sections/head.jsp" />
<jsp:include page="sections/footer.jsp" />
<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">
</head>

<body class="bg" style="background-image:url(<c:url value='/resources/images/background.jpg' />)">
	<jsp:include page="sections/navMenu.jsp" />
	<div class="container col-6 bg-white"
		style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
		<div class="d-flex justify-content-center" style="margin-top: 3%;">
			<h1>
				<i class="fa fa-user-circle fa-2x"></i>
			</h1>
		</div>
		<div class="d-flex justify-content-center">
			<h3>
				<spring:message code="navMenu.login" />
			</h3>
		</div>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<spring:message code="login.credentials.failure" />
			</div>
		</c:if>
		<form
			action="<c:url value= "/j_spring_security_check">
            </c:url>"
			method="post" style="margin-top: 3%;">
			<div class="form-group row d-flex justify-content-center">
				<label for="dni" class="col-4 col-form-label"> <b>DNI/NIE</b>
					<input class="form-control" type="text" placeholder="12345678X"
					name="j_username">
				</label>
			</div>
			<div class="form-group row d-flex justify-content-center">
				<label for="password" class="col-4 col-form-label"> <!-- Revisar los j_password y j_dni ?-->
					<b><spring:message code="user.password" /></b> <input
					class="form-control" type="password" id="password"
					name="j_password">
				</label>
			</div>
			<div class="d-flex justify-content-center">
				<a href="<c:url value='/signUp'/>"><spring:message
						code="navMenu.signIn" /></a>
			</div>
			<br>
			<div class="d-flex justify-content-center" style="margin-bottom: 4%;">
				<button type="submit" class="btn btn-outline-success">
					<spring:message code="navMenu.login" />
				</button>
			</div>
		</form>
	</div>
</body>

</html>