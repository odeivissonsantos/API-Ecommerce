package io.github.zero75griffes.services;

import java.util.List;
import java.util.UUID;

import io.github.zero75griffes.dtos.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.zero75griffes.entitys.Categoria;
import io.github.zero75griffes.exceptions.ObjectNotFoundException;
import io.github.zero75griffes.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	// Busca todas as Categorias
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	// Buscar Categoria pelo id
	public Categoria buscarPorId(Long id) throws ObjectNotFoundException {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada:: " + id));
	}
	
	// Criar uma nova Categoria;
	public Categoria criarCategoria(Categoria obj) {
		obj.setId(null);
		obj.setGuid(UUID.randomUUID().toString());
		return categoriaRepository.save(obj);
	}
	
	//Deletar por id
	public void delarPorId(Long id) throws ObjectNotFoundException {
		verificaSeExiste(id);
		categoriaRepository.deleteById(id);
	}

	//Atualiza por id
	public Categoria atualizarCategoria (Long id, CategoriaDTO objDTO) throws ObjectNotFoundException {
		Categoria obj = verificaSeExiste(id);
		obj.setNome(objDTO.getNome());
		return categoriaRepository.save(obj);
	}
	
	//verifica se a categoria existe pelo id
	public Categoria verificaSeExiste(Long id) throws ObjectNotFoundException {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada:: " + id));
	}


}
