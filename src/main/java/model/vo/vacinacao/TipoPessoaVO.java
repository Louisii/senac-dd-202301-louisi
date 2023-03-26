package model.vo.vacinacao;

public enum TipoPessoaVO {
	
	//1.PESQUISADOR 2.VOLUNTARIO 3.GERAL
	
	PESQUISADOR (1),
	VOLUNTARIO (2),
	PUBLICO_GERAL (3);
	
	private int valor;
	
	private TipoPessoaVO(int valor) {
	this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static TipoPessoaVO getTipoPessoaPorValor(int valor) {
		TipoPessoaVO tipoPessoa = null;
		for(TipoPessoaVO elemento : TipoPessoaVO.values()) {
			if(elemento.getValor() == valor) {
				tipoPessoa = elemento;
			}
		}
		return tipoPessoa;
	}
}
