<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
	<c:if test="${not empty mensagem}">
		<p class="mensagem">
			${mensagem}
		</p>
	</c:if>
	
	<h3>Lista de Livros</h3>
	
	<ul>
	
		<c:forEach items="${livroList}" var="livro">
			
			<li>${livro.titulo} - ${livro.descricao} - 
				<a href="${linkTo[LivrosController].edita}?isbn=${livro.isbn}">
				Modificar
				</a>
			</li>
			
		</c:forEach>
	
	</ul>
	
</body>
</html>