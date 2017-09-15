<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<h2>Transactions</h2>
<section>
        <form method="post" action="transactions/filter">
            <dl>
                <dt>From Date:</dt>
                <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
            </dl>
            <dl>
                <dt>To Date:</dt>
                <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
            </dl>
            <button type="submit">Filter</button>
        </form>

    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Transaction ID</th>
            <th>AccountFrom</th>
            <th>Sender Name</th>
            <th>AccountTo</th>
            <th>Description</th>
            <th>Recipient Name</th>
            <th>Type</th>
            <th>Date & Time</th>
            <th>Amount</th>
        </tr>
        </thead>
        <c:forEach items="${transactions}" var="tx">
            <jsp:useBean id="tx" scope="page" type="com.bank.model.Transaction"/>
            <tr>
                <td>${tx.id}</td>
                <td>${tx.accountFrom.id}</td>
                <td>${tx.accountFrom.client.name}</td>
                <td>${tx.accountTo.id}</td>
                <td>${tx.description}</td>
                <td>${tx.accountTo.client.name}</td>
                <td>${tx.type}</td>
                <td>${tx.dateTime}</td>
                <td>${tx.amount}</td>
            </tr>
        </c:forEach>
    </table>
</section>


<section>
    <h2>Transfers:</h2>
    <form method="post" action="transactions">

        <input type="hidden" name="id" value="${tx.id}">
        <dl>
            <dt>AccountFrom:</dt>
            <dd><input type="text" value="${tx.accountFrom}" size=40 name="accountFrom"></dd>
        </dl>
        <dl>
            <dt>Transaction Type:</dt>
            <select name="type" id="type">
                <option value="INNER_TRANSFER">My accounts</option>
                <option value="OUTER_TRANSFER">Any accounts</option>
            </select>
        </dl>
        <dl>
            <dt>AccountTo</dt>
            <dd><input type="text" value="${tx.accountTo}" size=40 name="accountTo"></dd>
        </dl>
        <dl>
            <dt>Amount:</dt>
            <dd><input type="text" value="${tx.amount}" size=40 name="amount"></dd>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>