package io.github.zero75griffes.services;

import io.github.zero75griffes.entitys.Categoria;
import io.github.zero75griffes.entitys.Produto;
import io.github.zero75griffes.exceptions.ObjectNotFoundException;
import io.github.zero75griffes.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    //lista todos os produtos
    public List<Produto> listarTodos(Long id_cat) throws ObjectNotFoundException {
        categoriaService.verificaSeExiste(id_cat);
        return produtoRepository.listarTodosPorCategoria(id_cat);
    }

    //Busca um produto por id
    public Produto buscarPorId(Long id) throws ObjectNotFoundException {
        return verificaSeExiste(id);
    }


    //verifica existe Produto por id
    private Produto verificaSeExiste(Long id) throws ObjectNotFoundException {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado:: " + id));
    }

    //Cria um novo produto
    public Produto criarProduto(Long id_cat, Produto obj) {
        obj.setId(null);
        Categoria cat = categoriaService.verificaSeExiste(id_cat);
        obj.setCategoria(cat);
        obj.setGuid(UUID.randomUUID().toString());
        return produtoRepository.save(obj);
    }

    //Atualiza um produto
    public Produto atualizarProduto(Long id, Produto obj) throws ObjectNotFoundException {
        Produto newObj = verificaSeExiste(id);
        atualizaData(newObj, obj);
        return produtoRepository.save(newObj);
    }

    //método com a responsabilidade de passar os dados do produto antigo para o produto com novos dados
    private void atualizaData(Produto newObj, Produto obj) {
        newObj.setNome(obj.getNome());
        newObj.setMarca(obj.getMarca());
        newObj.setUrlImagem(obj.getUrlImagem());
        newObj.setTamanho(obj.getTamanho());
        newObj.setValor(obj.getValor());
    }

    public void deletarProduto(Long id) throws ObjectNotFoundException {
        verificaSeExiste(id);
        produtoRepository.deleteById(id);
    }
}
