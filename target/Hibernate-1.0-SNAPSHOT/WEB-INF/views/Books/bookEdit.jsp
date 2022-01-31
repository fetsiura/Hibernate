<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
EDIT:

<form:form method="post" modelAttribute="book"  >
    <form:hidden path="id"/>
    Title: <form:input path="title" />
    Description: <form:input path="description" />
    Rating: <form:input path="rating" />

    Publisher:
    <form:select itemValue="id" itemLabel="name"
                 path="publisher" items="${publishers}"/>

    <input type="submit" value="Save">
</form:form>