<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="sections/head.jsp"/>
    </head>
    <body>
        <c:set var="activeUserData" value="active" scope="request" />
        <jsp:include page="sections/navMenu.jsp"/>
        <div class="container-fluid" >
            <form:form modelAttribute="user" class="form-horizontal">
                <fieldset>
                    <legend>
                        <sec:authorize access="hasAnyRole('ROLE_USER')">
                            <c:set var="hasRoleUser" value="true" scope="request" />
                            <spring:message code= "user.userData"/>
                        </sec:authorize>
                        <sec:authorize access="!hasAnyRole('ROLE_USER')">
                            <c:set var="hasRoleUser" value="false" scope="request" />
                            <spring:message code= "user.signUp"/>
                        </sec:authorize>
                    </legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="email">
                            <spring:message code= "user.user.email"/>
                        </label>
                        <div class="col-lg-10">
                            <form:input id="email" path="username" type="text" class="form:input-large" disabled="${hasRoleUser}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">
                            <spring:message code= "user.user.password"/>
                        </label>
                        <div class="col-lg-10">
                            <form:password id="password" path="password" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="price">
                            <spring:message code= "user.user.firstName"/>
                        </label>
                        <div class="col-lg-10">
                            <form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="producer">
                            <spring:message code= "user.user.lastName"/>
                        </label>
                        <div class="col-lg-10">
                            <form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-success"
                                   value ="<spring:message code= "user.submit"/>"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </body>
</html>
