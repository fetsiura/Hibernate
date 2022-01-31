<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td>
                <a href="<c:url value="/books/update/${book.id}"/>">Edit</a>
            </td>
            <td>
                <a href="<c:url value="/books/delete/${book.id}"/>">Delete</a>

            </td>
        </tr>
    </c:forEach>
    <br>
    <a href="<c:url value="/books/form"/>">Add new Book</a>
</table>
