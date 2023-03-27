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
			query.setInt(5, novaVacina.getPesquisadorResponsavel().getIdPessoa());
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
	
	
	public boolean atualizar(VacinaVO vacinaEditada) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql =  " UPDATE VACINACAO.VACINA "
				    + " SET NOME = ?, PAIS_DE_ORIGEM = ?, ESTAGIO_DA_PESQUISA = ?, "
				    + " DT_INICIO_PESQUISA = ?, ID_PESQUISADOR_RESPONSAVEL = ? "
				    + " WHERE ID_VACINA = ? ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, vacinaEditada.getNome());
			query.setString(2, vacinaEditada.getOrigem());
			query.setInt(3, vacinaEditada.getEstagio());
			query.setString(4, vacinaEditada.getDtIniPesquisa());
			query.setInt(5, vacinaEditada.getPesquisadorResponsavel().getIdPessoa());
			query.setInt(6, vacinaEditada.getIdVacina());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar vacina. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return atualizou;
	}
	
	
	public VacinaVO consultarPorId(int id_vacina) {
		VacinaVO vacinaBuscada = null;
		PessoaDAO pesquisadorResponsavelBuscado = new PessoaDAO();
		Connection conexao = Banco.getConnection();
		String sql = " select * from vacinacao.vacina "
				   + " where id_vacina = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id_vacina);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				vacinaBuscada = new VacinaVO();
				vacinaBuscada.setIdVacina(resultado.getInt("id_vacina"));
				vacinaBuscada.setNome(resultado.getString("nome"));
				vacinaBuscada.setOrigem(resultado.getString("PAIS_DE_ORIGEM"));
				vacinaBuscada.setDtIniPesquisa(resultado.getString("ESTAGIO_DA_PESQUISA"));
				vacinaBuscada.setDtIniPesquisa(resultado.getString("DT_INICIO_PESQUISA"));
				vacinaBuscada.setPesquisadorResponsavel(pesquisadorResponsavelBuscado.consultarPorId((resultado.getInt("ID_PESQUISADOR_RESPONSAVEL"))));
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro ao buscar vacina com id: " + id_vacina 
					+ "\n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return vacinaBuscada;
	}

}
