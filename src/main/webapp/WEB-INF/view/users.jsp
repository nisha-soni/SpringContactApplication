<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List - Contact Application</title>
         <s:url var="url_css" value="/static/css/style.css" />
        <link href="${url_css}" rel="stylesheet" type="text/css"></link>
        <s:url var="url_jqlib" value="/static/js/jquery-3.3.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            function changeStatus(uId, lStatus){
                $.ajax({
                    url:"change_status",
                    data:{userId:uId,loginStatus:lStatus},
                    success:function(data){
                        alert(data);
                    }                    
                });
            }
        </script>
    </head>
    <s:url var="url_bg" value="/static/images/background.jpg" />
    <body background="${url_bg}" style="padding-top: 150px;">
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
                    <h3>User List</h3>
                    <table border="1" width="100%">
                        <tr>
                            <th>SR.</th>
                            <th>USERID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>LOGINNAME</th>
                            <th>STATUS</th>
                        </tr>
                        <c:forEach var="u" items="${userList}" varStatus="st">
                            <tr>
                            <td>${st.count}</td>
                            <td>${u.userId}</td>
                            <td>${u.name}</td>
                            <td>${u.phone}</td>
                            <td>${u.email}</td>
                            <td>${u.address}</td>
                            <td>${u.loginame}</td>
                            <td>
                                <select id="id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val())">
                                    <option value="1">Active</option>
                                    <option value="2">Blocked</option>
                                </select>
                                    <script>
                                        $("#id_${u.userId}").val('${u.loginStatus}');
                                    </script>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
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
