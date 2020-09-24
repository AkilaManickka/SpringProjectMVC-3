<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
	<div class="container">
		<form:form method="POST" modelAttribute="AddressForm">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="text" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="address">address</form:label>
				<form:input path="address" type="text" class="form-control"
					required="required" />
				<form:errors path="address" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="city">City</form:label>
				<form:input path="city" type="text" class="form-control"
					required="required" />
				<form:errors path="city" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="state">state</form:label>
				<form:input path="state" type="text" class="form-control"
					required="required" />
				<form:errors path="state" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="country">country</form:label>
				<form:input path="country" type="text" class="form-control"
					required="required" />
				<form:errors path="country" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="Zipcode">Zipcode</form:label>
				<form:input path="Zipcode" type="text" class="form-control"
					required="required" />
				<form:errors path="Zipcode" cssClass="text-warning" />
			</fieldset>
	
			
	
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  	<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
	
  </body>
</html>