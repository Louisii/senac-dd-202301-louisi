package model.dao.vacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.vo.telefonia.Endereco;
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
			query.setString(2, novaPessoa.getDtNascimento().toString());
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
		String sql =  " UPDATE VACINACAO.PESSOA "
				    + " SET NOME = ?, DT_NASCIMENTO = ?, SEXO = ? , CPF = ?, TIPO = ? "
				    + " WHERE ID_PESSOA = ? ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setString(1, pessoaEditada.getNome());
			query.setString(2, pessoaEditada.getDtNascimento().toString());
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
				pessoaBuscada.setDtNascimento(LocalDate.parse(resultado.getString("DT_NASCIMENTO"),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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
	
	
	public boolean excluir(int idPessoa) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VACINACAO.PESSOA "
				   + " WHERE ID_PESSOA = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, idPessoa);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}
	
	
	public List<PessoaVO> consultarTodos() {
		List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM VACINACAO.PESSOA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				PessoaVO pessoaConsultada = converterDeResultSetParaEntidade(resultado);
				pessoas.add(pessoaConsultada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos as pessoas" 
								+ "\n Causa: " + e.getMessage());	
		}
		
		return pessoas;
	}
	
	private PessoaVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		PessoaVO PessoaConsultada = new PessoaVO(); 
		PessoaConsultada.setIdPessoa(resultado.getInt("ID_PESSOA"));
		PessoaConsultada.setNome(resultado.getString("NOME"));
		PessoaConsultada.setDtNascimento(LocalDate.parse(resultado.getString("DT_NASCIMENTO"),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		PessoaConsultada.setSexo(resultado.getString("SEXO"));
		PessoaConsultada.setCpf(resultado.getString("CPF"));
		PessoaConsultada.setTipo(resultado.getInt("TIPO"));
		return PessoaConsultada;
	}
	
	
}
