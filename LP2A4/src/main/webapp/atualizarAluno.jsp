<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Aluno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/cadastrar.css">
<title>Atualizar aluno</title>
</head>
<body>
	<nav>
		<span><a href="cadastrarAluno.jsp">Cadastrar aluno</a></span>
		<span><a href="consultarAluno.jsp">Consultar aluno</a></span>
	</nav>
	<main>
		<h1>Atualizar aluno</h1>
		<form action="AtualizarAlunoController" method="post">
			<%
				Aluno aluno = null;
				if(request.getAttribute("aluno") != null) {
					aluno = (Aluno) request.getAttribute("aluno");
				}
			%>
			<input type="hidden" name="matricula" value="<% out.print(aluno.getMatricula()); %>">
			<div class="form-field">
				<label>Nome</label>
				<input name="nome" value="<% out.print(aluno.getNome()); %>">
			</div>
			<div class="form-field">
				<label>CPF</label>
				<input name="cpf" value="<% out.print(aluno.getCpf()); %>">
			</div>
			<div class="form-field">
				<label>Telefone</label>
				<input name="telefone" value="<% out.print(aluno.getTelefone()); %>">
			</div>
			<div class="form-field">
				<label>Responsável</label>
				<input name="responsavel" value="<% out.print(aluno.getResponsavel()); %>">
			</div>
			<div class="form-field">
				<label>Semestre</label>
				<input name="semestre" value="<% out.print(aluno.getSemestre()); %>" id="semestre">
			</div>
			<div class="form-field">
				<input 
					type="submit" 
					name="atualizar"
					value="Atualizar aluno"
					class="create-button"
				>
			</div>
			<div class="form-field">
				<input type="hidden" name="matricula">
			</div>
			<div class="form-field">
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