package model.dao.vacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dao.Banco;
import model.vo.vacinacao.PessoaVO;

public class PessoaDAO {

	
	
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
