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
EDIT:

<form:form method="post" action="/books/update" modelAttribute="book"  >
    <form:hidden path="id"/>

    Title: <form:input path="title" /> <br>
    <form:errors path="title" cssClass="my-error"/><br>

    Description: <form:input path="description" /> <br>
    <form:errors path="description" cssClass="my-error"/><br>


    Rating: <form:input path="rating" /> <br>
    <form:errors path="rating" cssClass="my-error"/><br>


    Publisher:
    <form:select itemValue="id" itemLabel="name"
                 path="publisher" items="${publishers}"/><br>

    Authors:
    <form:select  path="authors" itemValue="id" itemLabel="lastName" items="${authors}" multiple="true">
    </form:select>

    <input type="submit" value="Save">
</form:form>

</body>
</html>