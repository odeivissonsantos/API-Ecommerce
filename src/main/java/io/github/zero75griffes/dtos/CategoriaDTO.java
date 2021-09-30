package io.github.zero75griffes.dtos;

import io.github.zero75griffes.entitys.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String guid;
	private String nome;

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.guid = obj.getGuid();
		this.nome = obj.getNome();
	}
}
