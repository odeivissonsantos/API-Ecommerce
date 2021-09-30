package io.github.zero75griffes.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.github.zero75griffes.enums.Tamanho;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Produto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String urlImagem;

    @Column
    private String marca;

    @Column
    private Double valor;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;

    @ManyToOne
    @JsonBackReference
    private Categoria categoria;

}