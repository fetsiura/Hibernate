<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
EDIT:

<form:form method="post" modelAttribute="publisher"  >
    <form:hidden path="id"/>
    Name: <form:input path="name" />


    <input type="submit" value="Save">
</form:form>