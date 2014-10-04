<%-- 
    Document   : measures
    Created on : Sep 28, 2014, 10:33:49 AM
    Author     : bradock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sticky-footer.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Measures</h1>
            </div>

            <table class="table">
                <c:forEach var="measure" items="${requestScope.measures}">
                    <tr>
                        <td>${measure.id}</td>
                        <td>${measure.timestamp}</td>
                        <td>${measure.value}</td>
                    </tr>
                </c:forEach>
            </table> 
        </div>

        <div class="footer">
            <div class="container">
                <p class="text-muted">Place sticky footer content here.</p>
            </div>
        </div>
    </body>
</html>
