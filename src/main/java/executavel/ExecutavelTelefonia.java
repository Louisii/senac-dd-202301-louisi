package main.java.executavel;

import java.util.ArrayList;
import java.util.List;

import main.java.model.dao.telefonia.EnderecoDAO;
import main.java.model.dao.telefonia.TelefoneDAO;
import main.java.model.vo.telefonia.Cliente;
import main.java.model.vo.telefonia.Endereco;
import main.java.model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("88000123", "Nereu Ramos", "10", "Centro", "Florian�polis", "SC");
		EnderecoDAO dbaDeEnderecos = new EnderecoDAO();
		//dbaDeEnderecos.inserir(endereco1);
		
		if(dbaDeEnderecos.excluir(1)) {
			System.out.println("Endere�o foi exclu�do");
		}else {
			System.out.println("Erro ao excluir endere�o");
		}
		
		/*
		 * if(endereco1.getId() != null) {
		 * System.out.println("Novo endere�o cadastrado"); }else {
		 * System.out.println("Erro ao cadastrar endere�o"); }
		 */
		
//		Endereco enderecoQueJaExiste = dbaDeEnderecos.consultarPorId(2);
//		
//		System.out.println(enderecoQueJaExiste);
//		enderecoQueJaExiste.setRua("Rua do limoeiro");
//		
//		boolean atualizou = dbaDeEnderecos.atualizar(enderecoQueJaExiste);
//		enderecoQueJaExiste = dbaDeEnderecos.consultarPorId(2);
//		if(atualizou) {
//			System.out.println("Endere�o foi atualizado");
//		}else {
//			System.out.println("Erro ao atualizar endere�o");
//		}
//		
//		System.out.println(enderecoQueJaExiste);
		
		
//		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
//		Telefone telefone1 = new Telefone("48", "32328888", true, false);
//		telefonesDoSocrates.add(telefone1);
//		telefonesDoSocrates.add(new Telefone("48", "98881234", true, true));
//		
//		Cliente pele = new Cliente("Edson Arantes", "11122233344", null, true, endereco1);
//		Cliente socrates = new Cliente("S�crates Brasileiro", "33322233344", telefonesDoSocrates, true, endereco1);
//		
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		clientes.add(pele);
//		clientes.add(socrates);
//		
//		System.out.println("------------ Clientes da firma ------------");
//		for(Cliente c: clientes) {
//			System.out.println(c.toString());
//		}
//		
//		for(int i=0; i < clientes.size(); i++) {
//			Cliente c = clientes.get(i);
//			System.out.println(c.toString());
//		}
		
	}
}