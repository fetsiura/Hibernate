<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="publisher" items="${publishers}">
        <tr>
            <td>${publisher.name}</td>
            <td>
                <a href="<c:url value="/publishers/update/${publisher.id}"/>">Edit</a>
            </td>
            <td>
                <a href="<c:url value="/publishers/delete/${publisher.id}"/>">Delete</a>
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