package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Aluno;

import java.io.IOException;

public class CadastraAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastraAlunoController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//Incluir verificações
		
		String mensagem;
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String responsavel = request.getParameter("responsavel");
		int semestre = Integer.parseInt(request.getParameter("semestre"));
		
		Aluno aluno = new Aluno(nome, cpf, telefone, responsavel, semestre);
		aluno.salvar();
		
		mensagem = "Aluno cadastrado com sucesso!";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
	}

}
