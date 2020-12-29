<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String view = request.getParameter("layoutmenu");
if(view.startsWith("login")) {
	pageContext.forward("login.jsp");
}else{
	pageContext.forward("layoutmenu.jsp"); 
}
%>