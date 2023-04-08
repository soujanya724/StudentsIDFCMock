<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcss.jsp" %>

</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">


<form:form action="insert" modelAttribute="empobject">
Email:<form:input path="email"/><br>
Password:<form:input path="pwd"/><br>
Name:<form:input path="name"/><br>
Phone:<form:input path="phone"/><br>
Role:<form:input path="role"/><br>
<form:button>submit</form:button>
</form:form>

</div>
</div>
</div>
</div>
</div>
</body>
</html>