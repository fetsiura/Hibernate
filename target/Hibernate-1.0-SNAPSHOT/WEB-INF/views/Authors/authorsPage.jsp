<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <th>First Name</th>
        <th>First Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="<c:url value="/authors/update/${author.id}"/>">Edit</a>
            </td>
            <td>
                <a href="<c:url value="/authors/delete/${author.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <br>
    <a href="<c:url value="/books/form"/>">Add new Book</a><br>
    <a href="<c:url value="/authors/form"/>">Add new Author</a> <br>
    <a href="<c:url value="/publishers/form"/>">Add new Publisher</a>

</table>


<a href="<c:url value="/publishers"/>">Publishers</a><br>
<a href="<c:url value="/authors"/>">Authors</a><br>
<a href="<c:url value="/books"/>">Books</a>