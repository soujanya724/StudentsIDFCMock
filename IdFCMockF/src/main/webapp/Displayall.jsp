<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.Studentdto"%>
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
<th>Studentid</th>
<th>StudentName</th>
<th>Emailid</th>
</tr>

<%
List<Studentdto> l=(List<Studentdto>)request.getAttribute("key");
for(Studentdto studentdto:l){
%>

<tr>
<td><%=studentdto.getStdid() %></td>
<td><%=studentdto.getEmailid()%></td>
<td><%=studentdto.getStdname()%></td>
</tr>
<%
}
%>
</table>
</body>
</html>