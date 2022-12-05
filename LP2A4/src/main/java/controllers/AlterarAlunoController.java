package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Aluno;

import java.io.IOException;

public class AlterarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarAlunoController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String excluir = request.getParameter("excluir");
		String atualizar = request.getParameter("atualizar");
		String matricula = request.getParameter("matricula");

		if (excluir != null && matricula != null) {
			new Aluno().excluir(Integer.valueOf(matricula));

			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarAluno.jsp");
			request.setAttribute("mensagem", "Aluno excluído com sucesso!");
			dispatcher.forward(request, response);
			
		} else if (atualizar != null && matricula != null) {
			Aluno aluno = new Aluno().buscarAlunoPorMatricula(Integer.valueOf(matricula));

			RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarAluno.jsp");
			request.setAttribute("aluno", aluno);
			dispatcher.forward(request, response);

		}
	}

}
