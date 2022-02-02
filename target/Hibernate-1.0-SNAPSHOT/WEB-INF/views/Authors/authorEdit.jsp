<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
EDIT:

<form:form method="post" modelAttribute="author"  >
    <form:hidden path="id"/>
    First Name: <form:input path="firstName" />
    Last Name: <form:input path="lastName" />


    <input type="submit" value="Save">
</form:form>