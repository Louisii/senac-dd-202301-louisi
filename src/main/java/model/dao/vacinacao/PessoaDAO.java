package model.dao.vacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.vacinacao.PessoaVO;

public class PessoaDAO {

	public PessoaVO inserir(PessoaVO novaPessoa) {
		
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO PESSOA (NOME, DT_NASCIMENTO, SEXO, CPF, TIPO) "
				    + " VALUES (?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, novaPessoa.getNome());
			query.setString(2, novaPessoa.getDtNascimento());
			query.setString(3, novaPessoa.getSexo());
			query.setString(4, novaPessoa.getCpf());
			query.setInt(5, novaPessoa.getTipo());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setIdPessoa(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir PESSOA. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			//Fechar a conexão
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return novaPessoa;
	}
	
	
	
public boolean atualizar(PessoaVO pessoaEditada) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql =  " UPDATE PESSOA "
				    + " SET NOME = ?, DT_NASCIMENTO = ?, SEXO = ? , CPF = ?, TIPO = ? "
				    + " WHERE ID_PESSOA = ? ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, pessoaEditada.getNome());
			query.setString(2, pessoaEditada.getDtNascimento());
			query.setString(3, pessoaEditada.getSexo());
			query.setString(4, pessoaEditada.getCpf());
			query.setInt(5, pessoaEditada.getTipo());
			query.setInt(6, pessoaEditada.getIdPessoa());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return atualizou;
	}
	
	
	public PessoaVO consultarPorId(int id_pessoa) {
		PessoaVO pessoaBuscada = null;
		Connection conexao = Banco.getConnection();
		String sql = " select * from vacinacao.pessoa "
				   + " where id_pessoa = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id_pessoa);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaBuscada = new PessoaVO();
				pessoaBuscada.setIdPessoa(resultado.getInt("id_pessoa"));
				pessoaBuscada.setNome(resultado.getString("nome"));
				pessoaBuscada.setDtNascimento(resultado.getString("DT_NASCIMENTO"));
				pessoaBuscada.setSexo(resultado.getString("sexo"));
				pessoaBuscada.setCpf(resultado.getString("cpf"));
				pessoaBuscada.setTipo(resultado.getInt("tipo"));
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro ao buscar pessoa com id: " + id_pessoa 
					+ "\n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoaBuscada;
	}
	
}
