package executavel;

import model.dao.vacinacao.PessoaDAO;
import model.dao.vacinacao.VacinaDAO;
import model.vo.vacinacao.PessoaVO;
import model.vo.vacinacao.VacinaVO;

public class ExeVacinacao {

	public static void main(String[] args) {

		PessoaDAO pessoaDao = new PessoaDAO();
		PessoaVO pessoaQueJaExiste = pessoaDao.consultarPorId(1);
		
		//System.out.println(pessoaQueJaExiste);
		
		PessoaVO p1 = new PessoaVO("Louisi", "29-10-2003", "F", "06359913909", 2);
		p1 = pessoaDao.consultarPorId(1);
		
		//System.out.println(dbaDePessoas.inserir(p1));
		
		VacinaDAO vacinaDao = new VacinaDAO();
		
		VacinaVO v1 = new VacinaVO("covid", "Brasil", 2, "01-01-2020", pessoaDao.consultarPorId(1) );
		
		//System.out.println(vacinaDao.inserir(v1));
		
		//System.out.println(vacinaDao.consultarPorId(1)); 
		
		//p1.setTipo(3);
		//System.out.println(pessoaDao.atualizar(p1));	
		//System.out.println(pessoaDao.consultarPorId(1));
		PessoaVO p2 = new PessoaVO("Artur", "29-10-2002", "M", "06359913909", 2);
		pessoaDao.inserir(p2);
		p2 = pessoaDao.consultarPorId(2);
		System.out.println(pessoaDao.consultarPorId(2));
		System.out.println(pessoaDao.excluir(2));	
		System.out.println(pessoaDao.consultarPorId(2));
		
	}

};
