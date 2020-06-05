<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!--  ?language=es  ?language=es-->
<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top"
	style="padding: 1%;">
	<div class="container">
		<sec:authorize access="!hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
			<a class="navbar-brand" href="<spring:url value='/'/>"><i
				class="fa fa-plus"></i> <spring:message code="navMenu.title" /> </a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
			<a class="navbar-brand" href="<spring:url value='/doctor/'/>"><i
				class="fa fa-plus"></i> <spring:message code="navMenu.title" /> </a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
			<a class="navbar-brand" href="<spring:url value='/patient/'/>"><i
				class="fa fa-plus"></i> <spring:message code="navMenu.title" /> </a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
			<sec:authentication var="user" property="principal" />
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item">
					<div class="dropdown">
						<button class="btn btn-dark dropdown-toggle" type="button"
							id="dropdownMenuButton2" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-globe" aria-hidden="true"></i>
							<spring:message code="navMenu.language" />
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
							<a class="dropdown-item" href="<c:url value='?language=es'/>">
								<i class="fa fa-flag" aria-hidden="true"></i> <spring:message
									code="navMenu.spanish" />
							</a> <a class="dropdown-item" href="<c:url value='?language=en'/>">
								<i class="fa fa-flag" aria-hidden="true"></i> <spring:message
									code="navMenu.english" />
							</a>
						</div>
					</div>
				</li>
				<li class="nav-item">
					<div class="dropdown">
						<button class="btn btn-dark dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-user-circle"></i>
							<c:out value="${sessionScope.user.name}" />
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<sec:authorize access="hasAnyRole('ROLE_PATIENT')">
								<a class="dropdown-item"
									href="<c:url value='/patient/updateUser'/>"><i
									class="fa fa-id-card-o"></i> <spring:message
										code="navMenu.myData" /></a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
								<a class="dropdown-item"
									href="<c:url value='/doctor/updateUser'/>"><i
									class="fa fa-id-card-o"></i> <spring:message
										code="navMenu.myData" /></a>
							</sec:authorize>
							<a class="dropdown-item" href="<c:url value='/logout'/>"><i
								class="fa fa-sign-out"></i> <spring:message
									code="navMenu.logout" /></a>
						</div>
					</div>
				</li>
			</ul>
		</sec:authorize>
		<sec:authorize access="!hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item">
					<div class="dropdown">
						<button class="btn btn-dark dropdown-toggle" type="button"
							id="dropdownMenuButton2" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-globe" aria-hidden="true"></i>
							<spring:message code="navMenu.language" />
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
							<a class="dropdown-item" href="<c:url value='?language=es'/>">
								<i class="fa fa-flag" aria-hidden="true"></i> <spring:message
									code="navMenu.spanish" />
							</a> <a class="dropdown-item" href="<c:url value='?language=en'/>">
								<i class="fa fa-flag" aria-hidden="true"></i> <spring:message
									code="navMenu.english" />
							</a>
						</div>
					</div>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value='/signUp'/>"><i class="fa fa-arrow-up"></i>
						<spring:message code="navMenu.signIn" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value='/check'/>"><i class="fa fa-sign-in"></i> 
						<spring:message code="navMenu.login" /></a></li>
			</ul>
		</sec:authorize>
	</div>
</nav>