package io.github.zero75griffes.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import io.github.zero75griffes.entitys.Usuario;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nomeCompleto;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String senha;

}
