package io.github.zero75griffes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.zero75griffes.entitys.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT obj FROM Produto obj WHERE obj.categoria.id = :id_cat ORDER BY nome")
    List<Produto> listarTodosPorCategoria(@Param(value = "id_cat") Long id_cat);
}
