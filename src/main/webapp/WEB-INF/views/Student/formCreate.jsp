<%--
  Created by IntelliJ IDEA.
  User: jaro
  Date: 27.01.2022
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="form-group">

</div>
<div class="container-fluid">
    <form:form method="post" modelAttribute="student">
        <label for="firstNameId">First Name:</label>
        <form:input class="form-control" type="text" path="firstName" id="firstNameId"/>

        <br/>

        <label for="lastNameId">Last Name:</label>
        <form:input class="form-control" type="text" path="lastName" id="lastNameId"/>

        <br/>

        <label>Gender:</label>
        <form:radiobuttons items="${genders}" path="gender"/>

        <br/>

        <label>Country:</label>
        <form:select class="form-control" path="country">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select>

        <br/>

        <label>Mailing list:</label>
        <form:checkbox path="mailingList"/>

        </br>

        <label>Notes:</label>
        <form:textarea class="form-control" path="notes" id="notesId"/>

        <br/>

        <label>Programming Skills:</label>
        <form:select class="form-control" path="programmingSkills" items="${programmingSkillsModel}" multiple="true"/>

        <br/>

        <label>Hobbies:</label>
        <form:checkboxes items="${hobbies}" path="hobbies"/>

        <br/>

        <input type="submit" class="btn btn-primary" value="Save">
    </form:form>
</div>
</body>
</html>

