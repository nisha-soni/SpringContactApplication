<%-- 
    Document   : index1
    Created on : 5 Jan, 2020, 1:30:01 PM
    Author     : Nisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:url var="url_reg_form" value="/reg_form" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> User Login  - Contact Application</title>
         <s:url var="url_css" value="/static/css/style.css" />
        <link href="${url_css}" rel="stylesheet" type="text/css"></link>
    </head>
    <s:url var="url_bg" value="/static/images/background.jpg" />
    <body background="${url_bg}" style="padding-top: 150px;" >
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%--Header--%>
                    <jsp:include page="include/header.jsp" />
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%--menu--%>
                    <jsp:include page="include/menu.jsp" />
                </td>
            </tr>
             <tr>
                <td height="350px" valign="top">
                    <%--Page Content--%>
                    <h3>User Login</h3>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                    <c:if test="${param.act eq 'lo'}">
                        <p class="success">Logout Successfully!</p>
                    </c:if>
                    <c:if test="${param.act eq 'reg'}">
                        <p class="success">User registered Successfully!</p>
                    </c:if>
                    <s:url var="url_login" value="/login/" />
                    <f:form action="${url_login}" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>Username</td>
                                <td><f:input path="loginName" /></td>
                            </tr>
                              <tr>
                                <td>Password</td>
                                <td><f:password path="password" /></td>
                            </tr>
                              <tr>
                                  <td colspan="2" align="right">
                                      <button>Login</button><br>
                                      <a href="${url_reg_form}">New User Registration</a>
                                  </td>
                            </tr>
                        </table>
                    </f:form>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%--Footer--%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
