<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<s:url var="url_reg_form" value="/reg_form" />
<s:url var="url_logout" value="/logout" />
<c:if test="${sessionScope.userId==null}">
    <%--user is not yet logged in:guest menu --%>
    <a href="#">HOME</a> | <a href="#">Login</a> | <a href="${url_reg_form}">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
    <%--admin is logged in--%>
    <a href="#">HOME</a> | <a href="<s:url value="/admin/users" />">User List</a> | <a href="${url_logout}">Logout</a> 
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
    <s:url var="url_uhome" value="/user/dashboard" />
    <s:url var="url_cform" value="/user/contact_form" />
    <s:url var="url_clist" value="/user/clist" />
    <%--general user is logged in--%>
    <a href="${url_uhome}">HOME</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Logout</a>
</c:if>
