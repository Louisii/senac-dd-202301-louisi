package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {
	//INSERT
	//INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL, ID_CLIENTE)
	//VALUES ('', '', '','', 'SC', '');

		/**
		 * Insere um novo telefone no banco
		 * @param novoTelefone o endereco a ser persistido
		 * @return o telefone inserido com a chave prim�ria gerada
		 */
		public Telefone inserir(Telefone novoTelefone) {
			//Conectar ao banco
			Connection conexao = Banco.getConnection();
			String sql =  " INSERT INTO TELEFONE (ID_CLIENTE, DDD, NUMERO, ATIVO, MOVEL) VALUES (?,?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
				
			//executar o INSERT
			try {
				query.setInt(5, novoTelefone.getIdCliente() != null ? novoTelefone.getIdCliente() : 0);
				query.setString(2, novoTelefone.getDdd());
				query.setString(3, novoTelefone.getNumero());
				query.setBoolean(4, novoTelefone.isAtivo());
				query.setBoolean(5, novoTelefone.isMovel());
				query.execute();
				
				//Preencher o id gerado no banco no objeto
				ResultSet resultado = query.getGeneratedKeys();
				if(resultado.next()) {
					novoTelefone.setId(resultado.getInt(1));
				}
				
			} catch (SQLException e) {
				System.out.println("Erro ao inserir endere�o. "
						+ "\nCausa: " + e.getMessage());
			}finally {
				//Fechar a conex�o
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);
			}
			
			return novoTelefone;
		}
		
		
		
		public boolean atualizar(Telefone telefoneEditado) {
			boolean atualizou = false;
			Connection conexao = Banco.getConnection();
			String sql = " UPDATE Telefone "
					   + " SET DDD = ?, NUMERO = ?, ATIVO = ?, "
					   + "     MOVEL = ?, ID_CLIENTE = ? "
					   + " WHERE ID = ? ";
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			try {
				query.setString(1, telefoneEditado.getDdd());
				query.setString(2, telefoneEditado.getNumero());
				query.setBoolean(3, telefoneEditado.isAtivo());
				query.setBoolean(4, telefoneEditado.isMovel());
				query.setInt(5, telefoneEditado.getIdCliente() != null ? telefoneEditado.getIdCliente() : 0);
				
				
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
		
		
		
}
