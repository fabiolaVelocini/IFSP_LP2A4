package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import DAOs.AlunoDAO;

@Entity
@Table(name="Aluno")
public class Aluno {
	
	@Id
	@Column
	private int matricula;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private String telefone;
	
	@Column
	private String responsavel;
	
	@Column
	private int semestre;
	
	@ManyToMany(targetEntity =  Disciplina.class)
	@JoinTable(
				name = "Disciplina_Aluno", 
				joinColumns = @JoinColumn(name = "matricula"), 
				inverseJoinColumns = @JoinColumn(name="idDisciplina")
			   )
	private List<Disciplina> disciplinas;
	
	public Aluno(String nome, String cpf, String telefone, String responsavel, int semestre) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.responsavel = responsavel;
		this.semestre = semestre;
	}
	
	public Aluno(String nome, String cpf, String telefone, String responsavel) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.responsavel = responsavel;
	}

	public Aluno() {
	
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void salvar() {
		new AlunoDAO().cadastrarAluno(this);
	}
	
	public void alterar() {
		new AlunoDAO().alterarProduto(this);
	}
	
	public void excluir(int matricula) {
		new AlunoDAO().excluirProduto(matricula);
	}
	
	public Aluno buscarAlunoPorMatricula(int matricula) {
		return new AlunoDAO().buscarAlunoPorMatricula(matricula);
	}
	
	public ArrayList<Aluno> buscarAlunosPorNome(String nome) {
		return new AlunoDAO().buscarAlunosPorNome(nome);
	}
}
