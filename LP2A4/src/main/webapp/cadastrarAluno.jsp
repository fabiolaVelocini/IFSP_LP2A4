<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar aluno</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/cadastrar.css">
</head>
<body>
	<nav>
		<span><a href="cadastrarAluno.jsp">Cadastrar aluno</a></span>
		<span><a href="consultarAluno.jsp">Consultar aluno</a></span>
	</nav>
	<main>
		<h1>Adicionar aluno</h1>
		<form action="CadastraAlunoController" method="post">
			<div class="form-field">
				<label>Nome</label>
				<input type="text" name="nome">
			</div>
			<div class="form-field">
				<label>CPF</label>
				<input type="text" name="cpf">
			</div>
			<div class="form-field">
				<label>Telefone</label>
				<input type="text" name="telefone">
			</div>
			<div class="form-field">
				<label>Responsável</label>
				<input type="text" name="responsavel">
			</div>
			<div class="form-field">
				<label>Semestre</label>
				<input type="number" min="1" max="6" name="semestre">
			</div>
			<div>
				<input 
					type="submit" 
					name="salvar" 
					value="Adicionar aluno"
					class="create-button"
				>
			</div>
			<div>
				<%
					String mensagem = (String) request.getAttribute("mensagem");
					if (mensagem != null)
						out.print(mensagem);
				%>
			</div>
		</form>
	</main>
</body>
</html>