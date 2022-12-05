package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@Column
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "idProprietario")
	private Proprietario proprietario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Veículo [id = " + id + ", proprietario = " + proprietario + "]";
	}

}
