<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table>
       <tr><th>id</th><th>名字</th><th>密码</th><th>类型</th></tr>
        <c:forEach items="${list}" var="user">
            <tr><td>${user.id}</td><td>${user.username}</td><td>${user.password}</td><td>${user.type}</td></tr>
        </c:forEach>
     </table>
</body>
</html>