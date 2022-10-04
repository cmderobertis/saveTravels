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
<h2 class="text-center">Edit Expense</h2>
<div class="row justify-content-center">
  <div class="col-8">
    <div class="card">
      <div class="card-body">
        <%--@elvariable id="expense" type=""--%>
        <form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
          <input type="hidden" name="_method" value="put">
          <p class="form-control d-flex flex-column">
            <form:label path="name">Name</form:label>
            <form:errors path="name" cssClass="text-danger"/>
            <form:input path="name"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor" cssClass="text-danger"/>
            <form:input path="vendor"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="amount">Amount</form:label>
            <form:errors path="amount" cssClass="text-danger"/>
            <form:input path="amount"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="description">Description</form:label>
            <form:errors path="description" cssClass="text-danger"/>
            <form:input path="description"/>
          </p>
          <input class="mt-3 btn btn-primary" type="submit" value="Submit">
        </form:form>
      </div>
    </div>
  </div>
</div>
<a href="/expenses">Back to expenses</a>
</body>
</html>