<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Book Form</title>
    <style>
        .my-error {
            color: red;
        }
    </style>
</head>
<body>
<form:form  method="post" modelAttribute="book">
    Title: <form:input path="title" /> <br>
<%--    <form:errors path="title" cssClass="my-error"/><br>--%>

    Description: <form:input path="description" /><br>
<%--    <form:errors path="description"/><br>--%>

    Rating: <form:input path="rating" /><br>
<%--    <form:errors path="rating"/><br>--%>

    Publisher:
    <form:select itemValue="id" itemLabel="name"
    path="publisher.id" items="${publishers}"/><br>

    Authors:
    <form:select  path="authors" itemValue="id" itemLabel="lastName" items="${authors}" multiple="true">

    </form:select>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
