package model.vo.vacinacao;

import java.time.LocalDate;

public class PessoaVO {
	
	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer idPessoa;
	private String nome;
	private LocalDate dtNascimento;
	private String sexo;
	private String cpf;
	private Integer tipo;
	
	public PessoaVO(Integer idPessoa, String nome, LocalDate dtNascimento, String sexo, String cpf, Integer tipo) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	
	public PessoaVO(String nome, LocalDate dtNascimento, String sexo, String cpf, Integer tipo) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "PessoaVO [idPessoa= " + idPessoa + ", nome= " + nome + ", dtNascimento= " + dtNascimento + ", sexo= " + sexo
				+ ", cpf= " + cpf + ", tipo= " + tipo + "]";
	}
	
}
