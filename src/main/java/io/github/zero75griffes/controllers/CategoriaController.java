package io.github.zero75griffes.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import io.github.zero75griffes.entitys.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.zero75griffes.dtos.CategoriaDTO;
import io.github.zero75griffes.exceptions.ObjectNotFoundException;
import io.github.zero75griffes.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listarTodos() {
		List<Categoria> list = categoriaService.listarTodos();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) throws ObjectNotFoundException {
		Categoria obj = categoriaService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> ciarCategoria(@RequestBody Categoria obj) {
		obj = categoriaService.criarCategoria(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) throws ObjectNotFoundException {
		categoriaService.delarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO objDTO) throws ObjectNotFoundException {
		Categoria newObj = categoriaService.atualizarCategoria(id, objDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
