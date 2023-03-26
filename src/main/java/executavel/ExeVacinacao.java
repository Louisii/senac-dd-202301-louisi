package executavel;

import model.dao.vacinacao.PessoaDAO;
import model.vo.vacinacao.PessoaVO;

public class ExeVacinacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PessoaDAO dbaDePessoas = new PessoaDAO();
		PessoaVO pessoaQueJaExiste = dbaDePessoas.consultarPorId(1);
		
		System.out.println(pessoaQueJaExiste);
		
	}

}
