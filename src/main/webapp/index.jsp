<%--
  User: zayvion
  Date: 2019-08-25
  Time: 20:32
  Description：
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<h1>hello world!小伙伴们！</h1>
</body>
</html>
