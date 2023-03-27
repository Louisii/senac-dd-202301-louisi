package executavel;

import model.dao.vacinacao.PessoaDAO;
import model.dao.vacinacao.VacinaDAO;
import model.vo.vacinacao.PessoaVO;
import model.vo.vacinacao.VacinaVO;

public class ExeVacinacao {

	public static void main(String[] args) {

		PessoaDAO dbaDePessoas = new PessoaDAO();
		PessoaVO pessoaQueJaExiste = dbaDePessoas.consultarPorId(1);
		
		System.out.println(pessoaQueJaExiste);
		
		PessoaVO p1 = new PessoaVO("Louisi", "29-10-2003", "F", "06359913909", 2);
		
		//System.out.println(dbaDePessoas.inserir(p1));
		
		VacinaDAO vacinaDao = new VacinaDAO();
		
		VacinaVO v1 = new VacinaVO("covid", "Brasil", 2, "01-01-2020", dbaDePessoas.consultarPorId(1) );
		
		//System.out.println(vacinaDao.inserir(v1));
		
		System.out.println(vacinaDao.consultarPorId(1)); 
		
	}

}
