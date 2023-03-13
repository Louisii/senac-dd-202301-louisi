package main.java.model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.model.dao.Banco;
import main.java.model.vo.telefonia.Telefone;

public class TelefoneDAO {
	//INSERT
	//INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL, ID_CLIENTE)
	//VALUES ('', '', '','', 'SC', '');

		/**
		 * Insere um novo telefone no banco
		 * @param novoTelefone o endereco a ser persistido
		 * @return o telefone inserido com a chave primária gerada
		 */
		public Telefone inserir(Telefone novoTelefone) {
			//Conectar ao banco
			Connection conexao = Banco.getConnection();
			String sql =  " INSERT INTO TELEFONE (ID_CLIENTE, DDD, NUMERO, ATIVO, MOVEL) VALUES (?,?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
				
			//executar o INSERT
			try {
				(query.setInt(1, novoTelefone.getIdCliente() == null) ? 0 : novoTelefone.getIdCliente();
				
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
				System.out.println("Erro ao inserir endereço. "
						+ "\nCausa: " + e.getMessage());
			}finally {
				//Fechar a conexão
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);
			}
			
			return novoTelefone;
		}
		
		
}
