<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web开发篇—Jsp模板引擎渲染web视图</title>
</head>
 <body>
    <table style="text-align: center">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookName}</td>
                <td>${book.autor}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
 </body>
</html>
