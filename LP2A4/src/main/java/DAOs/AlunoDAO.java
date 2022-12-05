package DAOs;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Aluno;

public class AlunoDAO {
	
	public void cadastrarAluno(Aluno aluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Aluno> buscaAlunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
		List<Aluno> alunosEncontrados = buscaAlunos.getResultList();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		aluno.setNome(aluno.getNome());
		aluno.setCpf(aluno.getCpf());
		aluno.setTelefone(aluno.getTelefone());
		aluno.setResponsavel(aluno.getResponsavel());
		aluno.setSemestre(aluno.getSemestre());
		aluno.setMatricula(alunosEncontrados.size()+1);
		aluno.setDisciplinas(disciplinaDAO.buscarDisciplinasPorSemestre(aluno.getSemestre()));
		
		em.getTransaction().begin();
		
		em.persist(aluno);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
	public ArrayList<Aluno> buscarAlunosPorNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Aluno> buscaAlunos = em.createQuery("SELECT a FROM Aluno a WHERE nome LIKE " + "'%" + nome + "%'", Aluno.class);
		List<Aluno> alunosEncontrados = buscaAlunos.getResultList();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Aluno aluno = new Aluno();
		
		for (int i = 0; i < alunosEncontrados.size(); i ++) {
			aluno = new Aluno();
			aluno.setMatricula(alunosEncontrados.get(i).getMatricula());
			aluno.setNome(alunosEncontrados.get(i).getNome());
			aluno.setCpf(alunosEncontrados.get(i).getCpf());
			aluno.setTelefone(alunosEncontrados.get(i).getTelefone());
			aluno.setResponsavel(alunosEncontrados.get(i).getResponsavel());
			aluno.setSemestre(alunosEncontrados.get(i).getSemestre());
			aluno.setDisciplinas(alunosEncontrados.get(i).getDisciplinas());
			alunos.add(aluno);
		}
		
		em.close();
		emf.close();
		
		return alunos;
	}
	
	public Aluno buscarAlunoPorMatricula(int matricula) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, matricula);
		
		if (aluno != null) {
			aluno.setMatricula(aluno.getMatricula());
			aluno.setNome(aluno.getNome());
			aluno.setCpf(aluno.getCpf());
			aluno.setTelefone(aluno.getTelefone());
			aluno.setResponsavel(aluno.getResponsavel());
			aluno.setSemestre(aluno.getSemestre());
		}
		
		return aluno;
	}

	
	public void excluirAluno(int matricula) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, matricula);
		
		if (aluno != null) {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		} else {
			em.close();
			emf.close();
		}
		
	}

	public void alterarAluno(Aluno aluno) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		Aluno alunoAntigo = em.find(Aluno.class, aluno.getMatricula());	
		Aluno alunoNovo = new Aluno();
		
		if (alunoAntigo != null) {
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
			
			em.getTransaction().begin();
			alunoNovo = em.merge(alunoAntigo);
			
			alunoNovo.setMatricula(aluno.getMatricula());
			alunoNovo.setNome(aluno.getNome());
			alunoNovo.setCpf(aluno.getCpf());
			alunoNovo.setTelefone(aluno.getTelefone());
			alunoNovo.setResponsavel(aluno.getResponsavel());
			alunoNovo.setSemestre(aluno.getSemestre());
			alunoNovo.setDisciplinas(disciplinaDAO.buscarDisciplinasPorSemestre(aluno.getSemestre()));
			
			em.getTransaction().commit();
		} else {
			em.close();
			emf.close();
		}
	}

}
