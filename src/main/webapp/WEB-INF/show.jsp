<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tacos</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="text-center">Show</h2>
<div class="row justify-content-center">
  <div class="col-auto">
    <div class="card">
      <div class="card-body">
        <h3><c:out value="${expense.name}"/></h3>
        <p>Language: <c:out value="${expense.vendor}"/></p>
        <p>Pages: <c:out value="${expense.amount}"/></p>
        <p>Description: <c:out value="${expense.description}"/></p>
        <a href="/expenses/${expense.id}/edit">Edit</a>
      </div>
    </div>
  </div>
</div>
<a href="/expenses">Back to expenses</a>
</body>
</html>