<%@ page language="java" contentType="text/html" %>
<html>
<body bgcolor="green">
<%
int i=Integer.parseInt(request.getParameter("value1"));
int j=Integer.parseInt(request.getParameter("value2"));
int k=i+j;
out.println("sum="+k);
%>
</body>
</html>
