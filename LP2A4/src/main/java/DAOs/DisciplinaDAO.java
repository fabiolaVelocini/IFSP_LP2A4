package DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Disciplina;

public class DisciplinaDAO {

	public ArrayList<Disciplina> buscarDisciplinasPorSemestre(int semestre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Disciplina> buscaDisciplinas = em.createQuery("SELECT d FROM Disciplina d WHERE semestre = " + semestre, Disciplina.class);
		List<Disciplina> disciplinasEncontradas = buscaDisciplinas.getResultList();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Disciplina disciplina = new Disciplina();
		
		for (int i = 0; i < disciplinasEncontradas.size(); i ++) {
			disciplina = new Disciplina();
			disciplina.setIdDisciplina(disciplinasEncontradas.get(i).getIdDisciplina());
			disciplina.setSigla(disciplinasEncontradas.get(i).getSigla());
			disciplina.setNome(disciplinasEncontradas.get(i).getNome());
			disciplina.setSemestre(disciplinasEncontradas.get(i).getSemestre());
			disciplinas.add(disciplina);
		}
		
		em.close();
		emf.close();
		
		return disciplinas;
	}
	
}
