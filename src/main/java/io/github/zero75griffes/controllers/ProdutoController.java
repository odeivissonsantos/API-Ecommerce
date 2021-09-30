package io.github.zero75griffes.controllers;

import io.github.zero75griffes.dtos.ProdutoDTO;
import io.github.zero75griffes.entitys.Produto;
import io.github.zero75griffes.exceptions.ObjectNotFoundException;
import io.github.zero75griffes.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) throws ObjectNotFoundException {
        List<Produto> list = produtoService.listarTodos(id_cat);
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) throws ObjectNotFoundException {
        Produto obj = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
                                                @RequestBody Produto obj) {
        Produto newObj= produtoService.criarProduto(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) throws ObjectNotFoundException {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto obj) throws ObjectNotFoundException {
        Produto newObj = produtoService.atualizarProduto(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
