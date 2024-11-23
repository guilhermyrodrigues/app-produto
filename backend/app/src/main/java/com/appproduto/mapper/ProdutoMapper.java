package com.appproduto.mapper;

import com.appproduto.dto.ProdutoDto;
import com.appproduto.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    // Converte de ProdutoDTO para ProdutoModel (Entidade)
    ProdutoModel toEntity(ProdutoDto dto);

    // Converte de ProdutoModel (Entidade) para ProdutoDTO
    ProdutoDto toDTO(ProdutoModel entity);

    // Atualiza uma entidade ProdutoModel a partir de um ProdutoDTO
    void updateEntityFromDTO(ProdutoDto dto, @MappingTarget ProdutoModel entity);

    // Converte uma lista de ProdutoModel para uma lista de ProdutoDTO
    List<ProdutoDto> toDTOList(List<ProdutoModel> entities);

    // Converte uma lista de ProdutoDTO para uma lista de ProdutoModel
    List<ProdutoModel> toEntityList(List<ProdutoDto> dtos);
}
