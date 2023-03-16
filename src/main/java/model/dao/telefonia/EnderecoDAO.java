
package main.java.model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.model.dao.Banco;
import main.java.model.vo.telefonia.Endereco;

public class EnderecoDAO {

	/**
	 * Insere um novo endereco no banco
	 * @param novoEndereco o endereco a ser persistido
	 * @return o endereco inserido com a chave prim�ria gerada
	 */
	public Endereco inserir(Endereco novoEndereco) {
		//Conectar ao banco
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO ENDERECO (RUA, CEP, BAIRRO, "
					+ " CIDADE, ESTADO, NUMERO) "
				    + " VALUES (?,?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, novoEndereco.getRua());
			query.setString(2, novoEndereco.getCep());
			query.setString(3, novoEndereco.getBairro());
			query.setString(4, novoEndereco.getCidade());
			query.setString(5, novoEndereco.getEstado());
			query.setString(6, novoEndereco.getNumero());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoEndereco.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir endere�o. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			//Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novoEndereco;
	}
	
	public boolean atualizar(Endereco enderecoEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE ENDERECO "
				   + " SET CEP = ?, RUA = ?, NUMERO = ?, "
				   + "     BAIRRO = ?, CIDADE = ?, ESTADO = ? "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, enderecoEditado.getCep());
			query.setString(2, enderecoEditado.getRua());
			query.setString(3, enderecoEditado.getNumero());
			query.setString(4, enderecoEditado.getBairro());
			query.setString(5, enderecoEditado.getCidade());
			query.setString(6, enderecoEditado.getEstado());
			query.setInt(7, enderecoEditado.getId());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar endere�o. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return atualizou;
	}
	
	public Endereco consultarPorId(int id) {
		Endereco enderecoConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM ENDERECO "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				enderecoConsultado = new Endereco();
				enderecoConsultado.setId(resultado.getInt("id"));
				enderecoConsultado.setCep(resultado.getString("cep"));
				enderecoConsultado.setRua(resultado.getString("rua"));
				enderecoConsultado.setBairro(resultado.getString("bairro"));
				enderecoConsultado.setNumero(resultado.getString("numero"));
				enderecoConsultado.setCidade(resultado.getString("cidade"));
				enderecoConsultado.setEstado(resultado.getString("estado"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar endere�o com id: + " + id 
								+ "\n Causa: " + e.getMessage());	
		}
		
		return enderecoConsultado;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM ENDERECO "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir endere�o. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}
	
	
	
	

}