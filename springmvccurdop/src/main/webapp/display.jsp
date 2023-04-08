<%@page import="com.jsp.jese8.dto.Empdto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<th>email</th>
<th>password</th>
<th>Name</th>
<th>phone</th>
<th>Role</th>
</tr>
<%
Empdto empdto=(Empdto) request.getAttribute("requestkey");

%>

<tr>
<td><%=empdto.getEmail() %></td>
<td><%=empdto.getPwd() %></td>
<td><%=empdto.getName() %></td>
<td><%=empdto.getPhone() %></td>
<td><%=empdto.getRole() %></td>
</tr>

</table>
</body>
</html>