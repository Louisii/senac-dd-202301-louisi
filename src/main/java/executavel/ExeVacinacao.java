package executavel;

import model.dao.vacinacao.PessoaDAO;
import model.dao.vacinacao.VacinaDAO;
import model.vo.vacinacao.PessoaVO;
import model.vo.vacinacao.VacinaVO;

public class ExeVacinacao {

	public static void main(String[] args) {

		PessoaDAO pessoaDao = new PessoaDAO();
		VacinaDAO vacinaDao = new VacinaDAO();
		
		PessoaVO p1 = new PessoaVO("Louisi", "29-10-2003", "F", "06359913909", 2);
		p1 = pessoaDao.consultarPorId(1);
		
		
		VacinaVO v2 = new VacinaVO("covid", "Brasil", 2, "01-01-2020", pessoaDao.consultarPorId(1) );
		
		v2 = vacinaDao.consultarPorId(2);
		
		System.out.println(vacinaDao.consultarPorId(1));
		
		v2.setEstagio(3);
		
		System.out.println(vacinaDao.atualizar(v2));
		
		System.out.println(vacinaDao.consultarPorId(1));
	}

};
