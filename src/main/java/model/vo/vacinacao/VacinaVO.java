package model.vo.vacinacao;

import java.time.LocalDate;

public class VacinaVO {
	
	private Integer idVacina;
	private String nome;
	private String origem;
	private Integer estagio;
	private LocalDate dtIniPesquisa;
	private PessoaVO pesquisadorResponsavel;

	public VacinaVO(String nome, String origem, Integer estagio, LocalDate dtIniPesquisa, PessoaVO pesquisadorResponsavel) {
		super();
		this.nome = nome;
		this.origem = origem;
		this.estagio = estagio;
		this.dtIniPesquisa = dtIniPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacinaVO(Integer idVacina,String nome, String origem, Integer estagio, LocalDate dtIniPesquisa,
			PessoaVO pesquisadorResponsavel) {
		super();
		this.idVacina = idVacina;
		this.nome = nome;
		this.origem = origem;
		this.estagio = estagio;
		this.dtIniPesquisa = dtIniPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	public Integer getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Integer idVacina) {
		this.idVacina = idVacina;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Integer getEstagio() {
		return estagio;
	}

	public void setEstagio(Integer estagio) {
		this.estagio = estagio;
	}

	public LocalDate getDtIniPesquisa() {
		return dtIniPesquisa;
	}

	public void setDtIniPesquisa(LocalDate dtIniPesquisa) {
		this.dtIniPesquisa = dtIniPesquisa;
	}

	public PessoaVO getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}

	public void setPesquisadorResponsavel(PessoaVO pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	@Override
	public String toString() {
		return "VacinaVO [idVacina= " + idVacina + ", nome= " + nome + ", origem= " + origem + ", estagio= " + estagio
				+ ", dtIniPesquisa= " + dtIniPesquisa + ", pesquisadorResponsavel= " + pesquisadorResponsavel.getNome() + "]";
	}
	
	
	
}
