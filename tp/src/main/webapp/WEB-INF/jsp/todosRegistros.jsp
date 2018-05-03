<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Employees page</h1>

<ul>
<c:forEach items="${informacion}" var="informacion">
   <li>${informacion}</li>
</c:forEach>
</ul>