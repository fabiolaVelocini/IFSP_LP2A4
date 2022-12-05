<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Aluno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar aluno</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/consultar.css">
</head>
<body>
	<nav>
		<span><a href="cadastrarAluno.jsp">Cadastrar aluno</a></span>
		<span><a href="consultarAluno.jsp">Consultar aluno</a></span>
	</nav>
	<main>
		<form action="BuscarAlunoController" method="post">
			<h1>Consultar aluno</h1>
			<div>
				<div class="filter">
					<label>
						<input type="text" name="nome" placeholder="Filtrar pelo nome">
					</label>
					<input 
						type="submit" 
						name="salvar"
						value="Consultar aluno"
						class="button"
					>
				</div>
				<div>
					<%
						String mensagem = (String) request.getAttribute("mensagem");
						if (mensagem != null)
							out.print(mensagem);
					%>
				</div>
			</div>
		</form>	
		<%
			if(request.getAttribute("alunos") != null) {
				List<?> alunos = (List<?>) request.getAttribute("alunos");
				for(int i = 0; i <= (alunos.size()-1); i++) {
					Aluno aluno = (Aluno) alunos.get(i);
		%>
			<form action="AlterarAlunoController" method="post" class="form">
				<div>
					<div class="tr">
						<span class="th">Matrícula</span>
						<span class="td"><% out.print(aluno.getMatricula()); %></span>
						<input type="hidden" name="matricula" value="<% out.print(aluno.getMatricula()); %>">
					</div>
					<div class="tr">
						<span class="th">Nome</span>
						<span class="td"><% out.print(aluno.getNome()); %></span>
						<input type="hidden" name="nome" value="<% out.print(aluno.getNome()); %>">
					</div>
					<div class="tr">
						<span class="th">CPF</span>
						<span class="td"><% out.print(aluno.getCpf()); %></span>
					</div>
					<div class="tr">
						<span class="th">Telefone</span>
						<span class="td"><% out.print(aluno.getTelefone()); %></span>
					</div>
					<div class="tr">
						<span class="th">Responsável</span>
						<span class="td"><% out.print(aluno.getResponsavel()); %></span>
					</div>
					<div class="tr">
						<span class="th">Semestre</span>
						<span class="td"><% out.print(aluno.getSemestre()); %></span>
					</div>
				</div>
				<div class = "buttons">
					<input
						type="submit"
						name="atualizar"
						value="Atualizar"
						class="button"
					>
					<input
						type="submit"
						name="excluir"
						value="Excluir"
						class="button delete-button"
					>
				</div>
			</form>
		<%
				} 
			} 
		%>
	</main>
</body>
</html>