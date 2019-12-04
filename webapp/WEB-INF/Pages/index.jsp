<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>ModelMadness</title>

<!-- Bootstrap core CSS -->

<!--Pulling Awesome Font -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style"/><link rel="stylesheet" href="${style}">
   <style>
   @media (max-width: 767px) {
    .block {
        margin-left: -20px;
        margin-right: -20px;
    }
}
</style>
   
</head>
  
<body>

<form:form modelAttribute="Appliances" action="saveApp"
			enctype="multipart/form-data" method="POST">

<div class="container-fluid">
<div class="row">
<div class="col-sm-4">

<div class="form-group">
      <label for="text">Id:</label>
					<form:input type="text" class="form-control" path="Id" value="${Appliances.Id}" />
				</div>
<div class="form-group">

 <label for="text">Units consumed:</label>
					<form:input type="text" class="form-control" path="units" value="${Appliances.units}" />
</div>
 
<div class="form-group">
   <label for="text">Rate per KWh:</label>
					<form:input type="text" class="form-control" path="ratePerUnit" value="${Appliances.ratePerUnit}" />
</div>

<div class="form-group">
   <label for="text">Number of Days:</label>
					<form:input type="text" class="form-control" path="noOfDays" value="${Appliances.noOfDays}" />
</div>



 <div> 
   	<select class="mdb-select md-form">
  <option value="" disabled selected>Choose your duration</option>
  <option value="${Calculate.costOfDays}">days</option>
  <option value="${Calculate.costOfMonths}">months</option>
  <option value="${Calculate.costOfYears}">years</option>
</select>

</div>



<br>
<div class="form-group">
<input type="submit" class="btn btn-info" value="Calculate"><br>
<input type="text" class="form-control" id="TotalBill">
 
</div>
</div>
</div>

</form:form>

</body>
</html>