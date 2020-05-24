<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid ">
    <div class="col-lg-8">
        <h2><span class="glyphicon glyphicon-heart-empty"></span> <spring:message code= "navMenu.title"/></h2>
    </div>
    <div class="col-lg-4 text-right">
        <div class="btn-group ">
            <a href="?language=es" class="btn btn-default"><spring:message code= "navMenu.spanish"/></a>
            <a href="?language=en" class="btn btn-default"><spring:message code= "navMenu.english"/></a>
        </div> 
    </div>
</div>
<div>
    <nav class="navbar navbar-default" data-spy="affix" data-offset-top="75">
        <ul class="nav navbar-nav">
            <li class="${activeCatalog}"><a href="<spring:url value='/'/>"><spring:message code= "navMenu.catalog"/></a></li>
        </ul>
        <sec:authorize access="hasAnyRole('ROLE_USER')">
            <sec:authentication var="user" property="principal" />
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div class="dropdown" style="margin:10px">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${user}
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li class="${activeUserData}"><a href="<spring:url value='/secured/updateUser'/>"><spring:message code= "navMenu.userData"/></a></li>
                            <li class="${activeOrders}"><a href="<spring:url value='/secured/orders'/>"><spring:message code= "navMenu.orders"/></a></li>
                            <li class="divider"></li>
                            <li>
                                <a href="<spring:url value='/logout'/>"><span class="glyphicon glyphicon-log-out"></span> <spring:message code= "navMenu.logout"/> </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="!hasAnyRole('ROLE_USER')" >
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<spring:url value='/signUp'/>"><span class="glyphicon glyphicon-user"></span> <spring:message code= "navMenu.signUp"/> </a></li>
                <li>
                    <a href="<spring:url value='/login'/>"><span class="glyphicon glyphicon-log-in"></span> <spring:message code= "navMenu.login"/> </a>
                </li>
            </ul>
        </sec:authorize>
    </nav>
</div>
