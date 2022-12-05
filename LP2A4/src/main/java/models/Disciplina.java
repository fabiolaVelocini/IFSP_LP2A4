package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Disciplina")
public class Disciplina {
	
	@Id
	@Column
	private int idDisciplina;
	
	@Column
	private String sigla;
	
	@Column
	private String nome;
	
	@Column
	private int semestre;
	
	public Disciplina(int idDisciplina, String sigla, String nome, int semestre) {
		super();
		this.idDisciplina = idDisciplina;
		this.sigla = sigla;
		this.nome = nome;
		this.semestre = semestre;
	}
	
	public Disciplina() {
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
}
