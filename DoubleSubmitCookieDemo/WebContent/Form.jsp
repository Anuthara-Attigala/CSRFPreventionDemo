<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Double Submit Cookie Demo</title>
<script>
function JsFunction(){
	document.write(Document.cookie);
	/*var cookies = Document.cookie;
	var cookieArr = cookies.split(";");
	for (i=0; i<cookieArr.lenght; i++){
		var cookie = cookies[i];
		document.write(cookie);
	}*/
}
</script>
</head>
<body>
<div>

<form action="DoubleSubmit" method="post">
<%  
//String name=request.getParameter("uname");  
out.print("welcome ");  
Cookie cks[] = request.getCookies();
for(Cookie ck:cks){
	String cookieName = ck.getName();
	String cookieValue = ck.getValue();
	if(cookieName.equalsIgnoreCase("CSRF")){
	%>	<input type="hidden" id="hiddenField" name="hiddenField" value =<%=cookieValue %>>
	<%
		request.setAttribute(cookieName, cookieValue);
		response.addCookie(ck);
	}
	
}
%>  


Enter Your New Password<input type="password" id="newPass" name="newPass"> <br/>
<input type="submit" value="Change"> 
</form>
</div>

</body>
</html>