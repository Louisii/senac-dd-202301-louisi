package executavel;

import java.time.LocalDate;

import model.dao.vacinacao.PessoaDAO;
import model.dao.vacinacao.VacinaDAO;
import model.vo.vacinacao.PessoaVO;
import model.vo.vacinacao.VacinaVO;

public class ExeVacinacao {

	public static void main(String[] args) {

		PessoaDAO pessoaDao = new PessoaDAO();
		VacinaDAO vacinaDao = new VacinaDAO();
		
		LocalDate date = LocalDate.of(2003, 10, 29);
		
		PessoaVO p1 = new PessoaVO("Louisi", date, "F", "123.123.123-01", 2);
		pessoaDao.inserir(p1);
		p1 = pessoaDao.consultarPorId(2);
		
		
		VacinaVO v2 = new VacinaVO("covid", "Brasil", 2, date, pessoaDao.consultarPorId(1));
		vacinaDao.inserir(v2);

		System.out.println(vacinaDao.consultarTodos());
		
		
	}

};
