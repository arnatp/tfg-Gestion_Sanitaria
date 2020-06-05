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

<body class="bg"
	style="background-image:url(<c:url value='/resources/images/background.jpg' />)">
	<jsp:include page="sections/navMenu.jsp" />
	<div class="jumbotron p-2">
		<div class="container">
			<h4 class="display-4"><spring:message code="welcomePage.name" /></h4>
			<p class="lead"><spring:message code="welcomePage.description" /></p>
		</div>
	</div>
	<div class="container col-6">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100"
						src="<c:url value='/resources/images/Carrousel1.jpg' />"
						alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100"
						src="<c:url value='/resources/images/Carrousel2.jpg' />"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100"
						src="<c:url value='/resources/images/Carrousel3.jpg' />"
						alt="Third slide">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
</body>

</html>