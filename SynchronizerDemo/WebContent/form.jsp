<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Synchronizer Token Pattern Demo</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.get("http://localhost:8080/SynchronizerDemo/FormServlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $("#testAjax").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    	$("#hiddenField").val(responseText) //Set the value of the CRFS token to the responseText sent by the servlet
	});
});
</script>
</head>
<body>
<form action="FormServlet" method="post">
Type your message here: <input type="text" name="message" id="message">
<input type="hidden" name="hiddenField" id="hiddenField">
<input type="submit" value="Send Message">'
<%  
//String name=request.getParameter("uname");  
out.print("Send Your Message! ");  
Cookie cks[] = request.getCookies();
for(Cookie ck:cks){
	String cookieName = ck.getName();
	String cookieValue = ck.getValue();
	if(cookieName.equalsIgnoreCase("myCookie")){
		request.setAttribute(cookieName, cookieValue);
		response.addCookie(ck); 
		
	}
	
}
//request.
%>  
</form>
<br/>
<div id="testAjax">
</div>
</body>
</html>