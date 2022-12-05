package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Aluno;

import java.io.IOException;

public class AtualizarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AtualizarAlunoController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String mensagem;
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
		
		if (
				nome != null && !nome.isEmpty() 
				&& !request.getParameter("cpf").isEmpty()
				&& !request.getParameter("telefone").isEmpty()
				&& !request.getParameter("responsavel").isEmpty()
				&& request.getParameter("semestre") != null
			){
			String cpf;
			String telefone;
			String responsavel;
			int semestre;
			
			cpf = request.getParameter("cpf");
			telefone = request.getParameter("telefone");
			responsavel = request.getParameter("responsavel");
			semestre = Integer.parseInt(request.getParameter("semestre"));
			
			Aluno aluno = new Aluno(nome, cpf, telefone, responsavel, semestre);
			aluno.setMatricula(Integer.valueOf(matricula));
			
			mensagem = "Aluno atualizado com sucesso!";
			request.setAttribute("mensagem", mensagem);
			dispatcher.forward(request, response);
			
			aluno.alterar();
			
		} else
			mensagem = "Por favor, preencha os campos corretamente.";
			request.setAttribute("mensagem", mensagem);
			dispatcher.forward(request, response);
	}

}
