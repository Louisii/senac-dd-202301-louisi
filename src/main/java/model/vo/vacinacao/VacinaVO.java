package model.vo.vacinacao;

public class VacinaVO {
	
	private Integer idVacina;
	private String nome;
	private String origem;
	private Integer estagio;
	private String dtIniPesquisa;
	private Integer idPesquisadorResponsavel;

	public VacinaVO(String nome, String origem, Integer estagio, String dtIniPesquisa, Integer idPesquisadorResponsavel) {
		super();
		this.nome = nome;
		this.origem = origem;
		this.estagio = estagio;
		this.dtIniPesquisa = dtIniPesquisa;
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
	}

	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacinaVO(Integer idVacina,String nome, String origem, Integer estagio, String dtIniPesquisa,
			Integer idPesquisadorResponsavel) {
		super();
		this.idVacina = idVacina;
		this.nome = nome;
		this.origem = origem;
		this.estagio = estagio;
		this.dtIniPesquisa = dtIniPesquisa;
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
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

	public String getDtIniPesquisa() {
		return dtIniPesquisa;
	}

	public void setDtIniPesquisa(String dtIniPesquisa) {
		this.dtIniPesquisa = dtIniPesquisa;
	}

	public Integer getIdPesquisadorResponsavel() {
		return idPesquisadorResponsavel;
	}

	public void setIdPesquisadorResponsavel(Integer idPesquisadorResponsavel) {
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
	}

	@Override
	public String toString() {
		return "VacinaVO [idVacina= " + idVacina + ", nome= " + nome + ", origem= " + origem + ", estagio= " + estagio
				+ ", dtIniPesquisa= " + dtIniPesquisa + ", idPesquisadorResponsavel= " + idPesquisadorResponsavel + "]";
	}
	
	
	
}
