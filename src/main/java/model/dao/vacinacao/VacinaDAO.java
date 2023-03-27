package model.dao.vacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.vo.vacinacao.PessoaVO;
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
	
	
	public boolean excluir(int idvacina) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VACINACAO.VACINA "
				   + " WHERE ID_VACINA = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, idvacina);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir vacina. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}
	
	
	
	public List<VacinaVO> consultarTodos() {
		List<VacinaVO> vacinas = new ArrayList<VacinaVO>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM VACINACAO.VACINA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				VacinaVO vacinaConsultada = converterDeResultSetParaEntidade(resultado);
				vacinas.add(vacinaConsultada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos as vacinas" 
								+ "\n Causa: " + e.getMessage());	
		}
		
		return vacinas;
	}
	
	private VacinaVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		VacinaVO vacinaConsultada = new VacinaVO(); 
		PessoaDAO pesquisadorResponsavelBuscado = new PessoaDAO();
		vacinaConsultada.setIdVacina(resultado.getInt("ID_VACINA"));
		vacinaConsultada.setNome(resultado.getString("NOME"));
		vacinaConsultada.setOrigem(resultado.getString("PAIS_DE_ORIGEM"));
		vacinaConsultada.setEstagio(resultado.getInt("ESTAGIO_DA_PESQUISA"));
		vacinaConsultada.setDtIniPesquisa(resultado.getString("DT_INICIO_PESQUISA"));
		vacinaConsultada.setPesquisadorResponsavel(pesquisadorResponsavelBuscado.consultarPorId((resultado.getInt("ID_PESQUISADOR_RESPONSAVEL"))));
		return vacinaConsultada;
	}
	

}
