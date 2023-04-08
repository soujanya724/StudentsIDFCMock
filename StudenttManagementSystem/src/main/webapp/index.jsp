<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<html>
<head>
<%@include file="allcss.jsp" %>
</head>
<body class="bg-light">
<%@include file="navbar.jsp" %>>



<div class="container p-3">
<div class="card">
<div class="card-body">

<p class="text-center fs-1">All Student Details</p>


<c:if test="${not empty succmsg }">
<p class="text-center text-success">${succmsg}</p>
<c:remove var="succmsg"/>
</c:if>

<c:if test="${not empty errormsg }">
<p class="text-center text-success">${errormsg}</p>
<c:remove var="errormsg"/>
</c:if>



<table class="table">
  <thead>
    <tr>
      <th scope="col">Full Name</th>
      <th scope="col">DOB</th>
      <th scope="col">Address</th>
      <th scope="col">Qualification</th>
       <th scope="col">Email</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  
  <%
  StudentDAO dao=new StudentDAO(DBConnect.getConn());
  List<Student> list=dao.getAllStudent();
  for(Student s: list){
  %>
  
  <tr>
      <th scope="row"><%=s.getFullName() %></th>
      <td><%=s.getDob() %></td>
      <td><%=s.getAddress() %></td>
      <td><%=s.getQualificationl() %></td>
      <td><%=s.getEmail() %></td>
       <td>
       <a href="edit_student.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-primary">Edit</a>
        <a href="delete?id=<%=s.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
       </td>
    </tr>
  <%   
  }
  %>
  
  
  

   
  </tbody>
</table>

</div>
</div>
</div>
</body>

</html>
