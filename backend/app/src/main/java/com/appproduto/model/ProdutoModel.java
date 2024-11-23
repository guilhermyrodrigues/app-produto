package com.appproduto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    @Column
    private String nome;
    @Column(columnDefinition = "text")
    private String descricao;
    @Column
    private Double preco;
    @Column
    private String marca;
}
