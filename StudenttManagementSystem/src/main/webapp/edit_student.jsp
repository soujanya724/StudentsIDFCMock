<%@page import="com.entity.Student"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcss.jsp" %>
</head>
<body class="bg-light">
<%@include file="navbar.jsp" %>



<div class="container">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">

<p class="fs-3 text-center">Edit Student</p>

<%

int id=Integer.parseInt(request.getParameter("id"));
StudentDAO dao=new StudentDAO(DBConnect.getConn());
Student s=dao.getStudentById(id);
%>

<form action="update" method="post">
  
  <div class="mb-3">
  <label class="form-label">Full Name</label>
    <input type="text" value="<%=s.getFullName() %>" name="name" class="form-control">
      </div>
      
      <div class="mb-3">
      <label class="form-label">DOB</label>
    <input type="date" value="<%=s.getDob() %>"  name="dob"class="form-control">
      </div>
     
     <div class="mb-3"> 
    <label class="form-label"> Address</label>
    <input type="text"   value="<%=s.getAddress() %>" name="address"class="form-control">
      </div>
      
      <div class="mb-3">
      <label class="form-label">Qualification</label>
    <input type="text" value="<%=s.getQualificationl() %>" name="qualification" class="form-control">
      </div>
      
      <div class="mb-3">
      <label class="form-label">email</label>
    <input type="email" value="<%=s.getEmail() %>" name="email" class="form-control">
      </div>
     
     <input type="hidden" name="id" value="<%=s.getId() %>">
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>

</div>
</div>
</div>
</div>
</div>



</body>
</html>