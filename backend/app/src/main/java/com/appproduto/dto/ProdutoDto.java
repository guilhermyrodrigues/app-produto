package com.appproduto.dto;

import lombok.Data;

@Data
public class ProdutoDto {
    private String nome;
    private String descricao;
    private Double preco;
    private String marca;
}
