<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
</head>
<body>
</body>
</html>
<%
	session.invalidate();
	String redirectURL = "/jeedemo/home.jsf";
	response.sendRedirect(redirectURL);
%>