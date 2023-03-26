package model.dao.vacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.vacinacao.VacinaVO;

public class VacinaDAO {
	
public VacinaVO inserir(VacinaVO novaVacina) {
	
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO VACINA (NOME, PAIS_DE_ORIGEM, ESTAGIO_DA_PESQUISA, DT_INICIO_PESQUISA, ID_PESQUISADOR_RESPONSAVEL) "
				    + " VALUES (?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, novaVacina.getNome());
			query.setString(2, novaVacina.getOrigem());
			query.setInt(3, novaVacina.getEstagio());
			query.setString(4, novaVacina.getDtIniPesquisa());
			query.setInt(5, novaVacina.getIdPesquisadorResponsavel());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaVacina.setIdVacina(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir vacina. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			//Fechar a conexão
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return novaVacina;
	}
	
	


}
