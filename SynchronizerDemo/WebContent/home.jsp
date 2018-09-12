<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Synchronizer Token Pattern Demo</title>
</head>
<body>
<%  
//String name=request.getParameter("uname");  
out.print("You logged in. These are your cookies ");  
Cookie cks[] = request.getCookies();
for(Cookie ck:cks){
	String cookieName = ck.getName();
	String cookieValue = ck.getValue();
	%>
	Cookie name : <b><%=cookieName %> </b><br>
      Cookie Value : <b><%=cookieValue %> </b><br>
      <%
}
%> 
<br>
<div>
Click the button to get a form to send a message!
</div>
<div>
<form action="CsrfServlet" method="post">
<input type="submit" value="Get Form">
</form>
</div>
</body>
</html>