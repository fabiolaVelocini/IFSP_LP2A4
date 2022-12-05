package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Veiculo;

public class Problema {

	public static void main(String[] args) {

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("lp2a4_a2");

		EntityManager em = emFactory.createEntityManager();

		List<Veiculo> veiculos = em.createQuery("FROM Veiculo", Veiculo.class).getResultList();
		System.out.println(veiculos);

	}

}
