<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<form:form method="post"
           modelAttribute="person">
    <form:input path="login" placeholder="login" /> <br>
    <form:input path="email" placeholder="email" /> <br>
    <form:input path="password" type="password" placeholder="password" /><br>
    <input type="submit" value="Save">
</form:form>
