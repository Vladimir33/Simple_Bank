<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="client" scope="request" type="com.bank.model.Client"/>
    <h2>Accounts of ${client.name}</h2>
    <c:set var="clientId" value="${client.id}"/>

    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Account ID</th>
            <th>Balance</th>
            <th>Type</th>
            <th>Description</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${accounts}" var="account">
            <jsp:useBean id="account" scope="page" type="com.bank.model.Account"/>
            <tr>
                <td>${account.id}</td>
                <td>${account.balance}</td>
                <td>${account.type}</td>
                <td>${account.description}</td>
                    <%--<td><a href="clients?id=${client.id}">Update</a></td>--%>
                <td><a href="accounts/delete?id=${account.id}&clientId=${clientId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>

<section>

    <hr>
    <form method="post" action="accounts">

        <input type="hidden" name="id" value="${account.id}">
        <input type="hidden" name="clientId" value="${clientId}">
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${account.description}" size=40 name="description"></dd>
        </dl>
        <dl>
            <dt>Account Type:</dt>
            <select name="type" id="type">
                <option value="Deposit">Deposit</option>
                <option value="Savings">Savings</option>
            </select>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>