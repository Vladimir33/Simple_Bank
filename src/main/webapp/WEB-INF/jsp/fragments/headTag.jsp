<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple Bank</title>
    <base href="${pageContext.request.contextPath}/"/>

</head>
<body>
<a href="/">
    <input type="button" value="Home"/>
</a>

<a href="transactions">
    <input type="button" value="Transactions"/>
</a>
</body>