<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="sections/head.jsp"/>
    </head>
    <body>
        <fmt:setLocale value="${pageContext.response.locale}" scope="session"/>
        <c:set var="activeCatalog" value="active" scope="request" />
        <jsp:include page="sections/navMenu.jsp"/>
        <div class=" container-fluid" >
            <div class="row">
                <div class="col-lg-8">
                    <c:forEach var="article" items="${articles}">
                        <div class="col-lg-4 col-sm-6 col-md-3" style="padding-bottom: 15px">
                            <div class="thumbnail">
                                <div class="caption">
                                    <h4>${article.name}</h4>
                                </div>
                                <img  src="<spring:url value='/images/${article.image}'/>" class="img-responsive"  />
                                <div class="panel panel-default">
                                    <div class="panel-body" style="height: 75px;overflow-y: auto;">
                                        ${article.description}
                                    </div>
                                </div>
                                        <p><fmt:formatNumber value="${article.price}" type="currency" currencySymbol="€"></fmt:formatNumber></p>
                                <a href="<spring:url value='/addToCart?reference=${article.reference}'/>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-shopping-cart"></span> <spring:message code="catalog.add.to.shopping.cart"/>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <form>
                    <div class="col-lg-4">
                        <div class="panel-group">
                            <div class="panel panel-info">
                                <div class="panel-heading"><spring:message code="catalog.shopping.cart"/></div>
                                <div class="panel-body">
                                    <c:forEach var="article" items="${shoppingCart.articles}">
                                        <div class="media">
                                            <div class="media-left">
                                                <a href="<spring:url value='/removeFromCart?reference=${article.key.reference}'/>" class="btn btn-danger btn-xs">
                                                    <span class="glyphicon glyphicon-remove"></span> 
                                                </a>
                                                <img src="<spring:url value='/images/${article.key.image}'/>" class="media-object" style="width:60px"><br/>
                                                <a href="<spring:url value='/addToCart?reference=${article.key.reference}'/>" class="btn btn-default btn-xs">
                                                    <span class="glyphicon glyphicon-plus"></span> 
                                                </a>
                                                <a href="<spring:url value='/decreaseFromCart?reference=${article.key.reference}'/>" class="btn btn-default btn-xs">
                                                    <span class="glyphicon glyphicon-minus"></span> 
                                                </a>
                                            </div>
                                            <div class="media-body">
                                                <h4 class="media-heading">${article.key.name}</h4>
                                                <p>${article.key.description}</p>
                                                <spring:message code="catalog.price"/>
                                                <fmt:formatNumber value="${article.key.price}" type="currency" currencySymbol="€"></fmt:formatNumber>
                                                    <br/>
                                                <spring:message code="catalog.quantity"/> ${article.value}
                                                <br/>
                                                <spring:message code="catalog.total"/>
                                                <fmt:formatNumber value="${article.key.price*article.value}" type="currency" currencySymbol="€"></fmt:formatNumber>
                                                    <br/>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <c:if test="${!empty shoppingCart.articles}">
                                    <div class="panel-footer">
                                        <spring:message code="catalog.shopping.cart.total"/><fmt:formatNumber value="${shoppingCart.totalPrice}" type="currency" currencySymbol="€"></fmt:formatNumber>
                                            <br/>
                                            <a href="<spring:url value='/secured/shopping'/>" class="btn btn-primary btn-md">
                                            <span class="glyphicon glyphicon-shopping-cart"></span> <spring:message code="catalog.go.shopping.now"/>
                                        </a>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
