package io.github.zero75griffes.dtos;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.github.zero75griffes.entitys.Produto;
import io.github.zero75griffes.enums.Tamanho;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String guid;
	private String nome;
	private String urlImagem;
	private String marca;
	private Double valor;

	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;

	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.guid = obj.getGuid();
		this.nome = obj.getNome();
		this.urlImagem = obj.getUrlImagem();
		this.marca = obj.getMarca();
		this.valor = obj.getValor();
		this.tamanho = obj.getTamanho();
	}
}
