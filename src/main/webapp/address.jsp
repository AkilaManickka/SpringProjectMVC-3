<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    <table class="table table-striped">
			<caption>Your Address is</caption>
			<thead>
				<tr>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Country</th>
					<th>Zipcode</th>
					<th></th>
					<th></th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${address}" var="address">
					<tr>
						<td>${address.address}</td>
						<td><fmt:formatDate value="${address.updatedDate}" pattern="dd/MM/yyyy"/></td>
						 <td>${address.city}</td>
						<td>${address.state}</td>
						<td>${address.country}</td>
						<td>${address.zip}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-address?id=${address.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-address?id=${address.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/events">Add a event</a>
		</div>
		<div>
			<a class="button" href="/add-address">Add a address</a>
		</div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</body>
</html>
