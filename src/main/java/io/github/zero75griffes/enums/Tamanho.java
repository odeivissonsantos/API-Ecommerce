package io.github.zero75griffes.enums;

public enum Tamanho {

	PP("pp"), 
	P("p"), 
	M("m"), 
	G("g"), 
	GG("gg"), 
	XG("xg");

	private String descricao;

	Tamanho(String descricao) {

		this.descricao = descricao;
	}

	public String getDescricao() {

		return descricao;
	}

}
