package controller.telefonia;

import java.util.List;

import model.bo.telefonia.TelefoneBO;
import model.exception.telefonia.CampoInvalidoException;
import model.exception.telefonia.TelefoneJaUtilizadoException;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	
	public Telefone inserir(Telefone novoTelefone) throws TelefoneJaUtilizadoException {
		//TODO validar o preenchimento dos campos obrigatÃ³rios
		return bo.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		//TODO validar o preenchimento dos campos obrigatÃ³rios
		return bo.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return bo.consultarTodos();
	}
}
