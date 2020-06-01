<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
    <div class="container">
        <a class="navbar-brand" href="<spring:url value='/'/>">
        <i class="fa fa-plus"></i>
        
            <spring:message code="navMenu.title" />
                 
        </a>
        <a href="?language=es" class="btn btn-secondary">Spanish</a>
		<a href="?language=en" class="btn btn-secondary">English</a>
        
        <sec:authorize access="hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
            <sec:authentication var="user" property="principal" />
            <ul class="nav navbar-nav ml-auto">
             <!--    <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/newVisit'/>"><i class="fa fa-calendar-plus-o"></i>
                        Solicitar visita</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/showHistory'/>"><i class="fa fa-history"></i>
                        Ver historial</a>
                </li>-->
                
                
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                                class="fa fa-user-circle"></i> <c:out value="${sessionScope.user.name}"/>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <sec:authorize access="hasAnyRole('ROLE_PATIENT')">
                            <a class="dropdown-item" href="<c:url value='/patient/updateUser'/>"><i
                                    class="fa fa-id-card-o"></i> Mis datos</a>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
                            <a class="dropdown-item" href="<c:url value='/doctor/updateUser'/>"><i
                                    class="fa fa-id-card-o"></i> Mis datos</a>
						</sec:authorize>
                            <a class="dropdown-item" href="<c:url value='/logout'/>"><i class="fa fa-sign-out"></i>
                                Cerrar sesión</a>
                        </div>
                        
                    </div>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="!hasAnyRole('ROLE_PATIENT','ROLE_EMPLOYEE')">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/signUp'/>"><i class="fa fa-arrow-up"></i>
                        Registrarse</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/check'/>"><i class="fa fa-sign-in"></i> Login</a>
                </li>
            </ul>
        </sec:authorize>
    </div>
</nav>