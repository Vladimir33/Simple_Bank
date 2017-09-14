<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>


<section>
    <h2>Clients</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>City</th>
            <th>Street</th>
            <th>Address Type</th>
            <th>Zip Code</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${clients}" var="client">
            <jsp:useBean id="client" scope="page" type="com.bank.model.Client"/>
            <tr>
                <td><a href="accounts?id=${client.id}">${client.name}</a></td>
                <td>${client.age}</td>
                <td>${client.address.city}</td>
                <td>${client.address.street}</td>
                <td>${client.address.type}</td>
                <td>${client.address.zipCode}</td>
                <td><a href="clients?id=${client.id}">Update</a></td>
                <td><a href="delete?id=${client.id}">Delete</a></td>

                    <%--<td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>--%>
            </tr>
        </c:forEach>
    </table>
</section>

<section>
    <%--<c:set var="create">Create</c:set>--%>
    <%--<c:set var="edit">Edit</c:set>--%>

    <%--<c:set var="client" value="${editedClient}"/>--%>
    <%--<h2>${client.id == null ? create : edit}</h2>--%>
    <hr>
    <form method="post" action="clients">

        <input type="hidden" name="id" value="${client.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${client.name}" size=40 name="name"></dd>
        </dl>
        <dl>
            <dt>Age:</dt>
            <dd><input type="text" value="${client.age}" size=40 name="age"></dd>
        </dl>
        <dl>
            <dt>Zip Code:</dt>
            <dd><input type="text" value="${client.address.zipCode}" size=40 name="zipCode"></dd>
        </dl>
        <dl>
            <dt>City:</dt>
            <dd><input type="text" value="${client.address.city}" size=40 name="city"></dd>
        </dl>
        <dl>
            <dt>Street:</dt>
            <dd><input type="text" value="${client.address.street}" size=40 name="street"></dd>
        </dl>
        <dl>
            <dt>Address Type:</dt>
            <select name="type" id="type">
                <option value="House">House</option>
                <option value="Apartment">Apartment</option>
            </select>
            <%--<dd><input type="text" value="${client.address.type}" size=40 name="type" placeholder="HOUSE"></dd>--%>
        </dl>

        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>

