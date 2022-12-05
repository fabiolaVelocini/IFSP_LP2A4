package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Disciplina_Aluno")
public class DisciplinaAluno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idDisciplinaAluno;
	
	@JoinColumn
	private int matricula;
	
	@JoinColumn
	private int idDisciplina;

	public int getIdDisciplinaAluno() {
		return idDisciplinaAluno;
	}

	public void setIdDisciplinaAluno(int idDisciplinaAluno) {
		this.idDisciplinaAluno = idDisciplinaAluno;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

}
