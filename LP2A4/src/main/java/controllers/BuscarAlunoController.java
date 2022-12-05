package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Aluno;

import java.io.IOException;
import java.util.ArrayList;

public class BuscarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscarAlunoController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String nome = request.getParameter("nome"); 
		ArrayList<Aluno> alunos = new Aluno().buscarAlunosPorNome(nome);
		
		request.setAttribute("alunos", alunos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarAluno.jsp");
		dispatcher.forward(request, response);
	}

}
