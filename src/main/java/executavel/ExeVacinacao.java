package executavel;

import model.dao.vacinacao.PessoaDAO;
import model.vo.vacinacao.PessoaVO;

public class ExeVacinacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PessoaDAO dbaDePessoas = new PessoaDAO();
		PessoaVO pessoaQueJaExiste = dbaDePessoas.consultarPorId(1);
		
		System.out.println(pessoaQueJaExiste);
		
		PessoaVO p1 = new PessoaVO("Louisi", "29-10-2003", "F", "06359913909", 2);
		
		System.out.println(dbaDePessoas.inserir(p1));
		
	}

}
