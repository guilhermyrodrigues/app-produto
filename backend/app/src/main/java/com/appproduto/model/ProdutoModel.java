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
    @Column(name =  "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "marca")
    private String marca;
}
