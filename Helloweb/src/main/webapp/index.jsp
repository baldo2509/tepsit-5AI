<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Benvenuto, utente curioso!</title>
	</head>
<body>
<p>
	Benvenuto Utente Curioso, questa è la mia prima JSP.
</p>
<p>
	Oggi è il giorno <%= (new java.util.Date()).toLocaleString() %>
</p>
<p>
	Autore: <a href="/author.jsp"> link </a>
</p>
</body>
</html>
