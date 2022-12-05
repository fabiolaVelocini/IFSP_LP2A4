package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Aluno;

public class JDBCAlunoDAO {
	
	public Aluno buscarAlunoPorMatricula(int matricula) {
		String sql = "SELECT * FROM ALUNO WHERE matricula = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		Aluno aluno = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, matricula);
			resultSet = statement.executeQuery();
			
			if (resultSet != null && resultSet.next()) {
				aluno = new Aluno();
				aluno.setMatricula(resultSet.getInt("matricula"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setCpf(resultSet.getString("cpf"));
				aluno.setTelefone(resultSet.getString("telefone"));
				aluno.setResponsavel(resultSet.getString("responsavel"));
				aluno.setSemestre(resultSet.getInt("semestre"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return aluno;
		
	}
	
	public ArrayList<Aluno> buscarAlunosPorNome(String nome) {
		String sql = "SELECT * FROM ALUNO WHERE nome LIKE '%" + nome + "%'";
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		Aluno aluno = null;
		ArrayList<Aluno> alunos = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			if (resultSet != null) {
				alunos = new ArrayList<Aluno>();
				while (resultSet.next()) {
					aluno = new Aluno();
					aluno.setMatricula(resultSet.getInt("matricula"));
					aluno.setNome(resultSet.getString("nome"));
					aluno.setCpf(resultSet.getString("cpf"));
					aluno.setTelefone(resultSet.getString("telefone"));
					aluno.setResponsavel(resultSet.getString("responsavel"));
					aluno.setSemestre(resultSet.getInt("semestre"));
					alunos.add(aluno);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return alunos;
		
	}
	
	
	public void cadastrarAluno(Aluno aluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp2a4");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Aluno> buscaAlunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
		List<Aluno> alunosEncontrados = buscaAlunos.getResultList();
		
		String sql = "INSERT INTO ALUNO VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, alunosEncontrados.size()+1);
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getTelefone());
			statement.setString(5, aluno.getResponsavel());
			statement.setInt(6, aluno.getSemestre());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
				
	}
	
	public void alterarAluno(Aluno aluno) {
		String sql = "UPDATE ALUNO SET nome = ?, cpf = ?, telefone = ?, responsavel = ?, semestre = ? WHERE matricula = ?";
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getCpf());
			statement.setString(3, aluno.getTelefone());
			statement.setString(4, aluno.getResponsavel());
			statement.setInt(5, aluno.getSemestre());
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void excluirAluno(int matricula) {
		String sql = "DELETE FROM ALUNO WHERE matricula = ?";
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, matricula);
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

