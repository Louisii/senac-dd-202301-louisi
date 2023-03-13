package main.java.executavel;

import java.util.ArrayList;
import java.util.List;

import main.java.model.vo.telefonia.Cliente;
import main.java.model.vo.telefonia.Endereco;
import main.java.model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("88000123", "Mauro Ramos", "10", "Centro", "Florianópolis", "SC");
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone1 = new Telefone("48", "32328888", true, false);
		telefonesDoSocrates.add(telefone1);
		telefonesDoSocrates.add(new Telefone("48", "98881234", true, true));
		
		Cliente pele = new Cliente("Edson Arantes", "11122233344", null, true, endereco1);
		Cliente socrates = new Cliente("Sócrates Brasileiro", "33322233344", telefonesDoSocrates, true, endereco1);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("------------ Clientes da firma ------------");
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}
		
		for(int i=0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			System.out.println(c.toString());
		}
		
	}
}
