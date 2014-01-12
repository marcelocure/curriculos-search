<%@page import="com.ilegra.curriculos.search.Searcher"%>
<%@page import="com.ilegra.curriculos.spring.GetBeans"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ilegra Currículos - Full Text Search</title>
</head>
<body>
	<div class="oauthDemo">
		<%
			if (request.getParameter("search") == null) {
				out.println("<form action=index.jsp>");
				out.println("Pesquisa: <input type=text name=search><input type=submit name=Pesquisar>");
				out.println("</form>");
			} else if (request.getParameter("search") != null) {
				Searcher searcher = new GetBeans().getSearcher();
				List<String> result = searcher.search(request.getParameter("search"));
				for (String url : result) {
					out.println("<p><a href="+url+" target=_blank>"+url+"</a></p>");
				}
				session.removeAttribute("search");
			}
		%>
	</div>
	<br />
</body>
</html>