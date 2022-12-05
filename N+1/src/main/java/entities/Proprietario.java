package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Proprietario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int id;
	
	@Column
	private String nome;
	
	@Column 
	private String cpf;
	
	@Column
	private String telefone;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Proprietário [id = " + id + ", nome = " + nome + "]";
	}

}
