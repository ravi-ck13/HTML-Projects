<%@page import="java.awt.geom.Path2D"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logout">
<table border="1px" style="background-color:yellow;">
<tr> <th>Tamil </th>
<th>English</th>
<th>Maths</th>
<th>Total</th>
<th>Status</th>

</tr>

<tr><td><%

HttpSession htp=request.getSession();
out.print(htp.getAttribute("u_name"));

%></td>

<td><%
out.print(htp.getAttribute("u_name1"));
%></td>

<td><%
out.print(htp.getAttribute("u_name2"));
%></td>

<td><%
out.print(htp.getAttribute("u_name3"));
%></td>

<td><%
out.print(htp.getAttribute("u_name4"));
%></td>

</tr>
</table>

<button>Logout</button>
</form>
</body>
</html>