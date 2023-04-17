package controller.telefonia;

import java.util.List;

import model.bo.telefonia.TelefoneBO;
import model.exception.telefonia.CampoInvalidoException;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	
	public Telefone inserir(Telefone novoTelefone) throws CampoInvalidoException {
		validarCamposObrigatorios(novoTelefone);
		return bo.inserir(novoTelefone);
	}
	
	private void validarCamposObrigatorios(Telefone telefone) throws CampoInvalidoException {
		String mensagemValidacao = "";
		
		mensagemValidacao += validarString(telefone.getDdd(), "DDD");
		mensagemValidacao += validarString(telefone.getNumero(), "número");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}
	
	private String validarString(String texto, String nomeCampo) {
		boolean valido = (texto != null) && !texto.trim().isEmpty();
		
		if(valido) {
			return "";
		}else {
			return 	"- " + nomeCampo + "\n" ;
		}
	}

	public boolean atualizar(Telefone telefoneAlterado) {
		//TODO validar o preenchimento dos campos obrigatórios
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
