<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <c:set var="title" value="Error" scope="page" />
</head>
        <body>
        <div class="container">
            <tr>
                <td class="content">
                    <%-- CONTENT --%>

                    <h2 class="error">
                        The following error occurred
                    </h2>
                    <c:set var="code" value="${requestScope['javax.servlet.error.status_code']}"/>
                    <c:if test="${not empty code}">
                        <h3>Error code: ${code}</h3>
                    </c:if>

                </td>
            </tr>
        </div>

        </body>
</html>
