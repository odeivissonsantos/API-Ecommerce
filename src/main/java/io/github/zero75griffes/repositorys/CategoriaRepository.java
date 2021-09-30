package io.github.zero75griffes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.zero75griffes.entitys.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
