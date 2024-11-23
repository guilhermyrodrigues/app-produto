package com.appproduto.service;

import com.appproduto.dto.ProdutoDto;
import com.appproduto.mapper.ProdutoMapper;
import com.appproduto.model.ProdutoModel;
import com.appproduto.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço para gerenciamento de produtos. Implementa as operações de
 * criação, leitura, atualização e remoção de itens de um pedido.
 */

@Service
@Slf4j
public class ProdutoService{

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    /**
     * Cria um novo no pedido.
     *
     * @param entity DTO do pedido a ser criado
     * @return DTO do pedido criado
     */


    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto create(ProdutoDto entity) {
        log.info("ProdutoService::create - Criando produto");
        log.debug("Valores: {}", entity);
        ProdutoModel produtoModel = produtoMapper.toEntity(entity);
        ProdutoModel produtoSalvo = produtoRepository.save(produtoModel);
        return produtoMapper.toDTO(produtoSalvo);
    }

    /**
     * Busca um pedido com base no seu identificador.
     *
     * @param id ID do pedido a ser buscado
     * @return DTO do pedido encontrado
     */


    @Transactional(readOnly = true)
    public ProdutoDto read(Integer id) {
        log.info("ProdutoService::read(id) - Buscando produto com ID: {}", id);
        return produtoRepository.findById(id)
                .map(produtoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado"));
    }

    /**
     * Retorna uma lista de todos os pedidos.
     *
     * @return Lista de DTOs dos pedidos
     */

    @Transactional(readOnly = true)
    public List<ProdutoDto> read() {
        log.info("ProdutoService::read() - Buscando todos os produtos");
        List<ProdutoModel> produtoModels = produtoRepository.findAll();
        return produtoMapper.toDTOList(produtoModels);
    }

    /**
     * Atualiza um pedido com base no ID informado.
     *
     * @param id ID do pedido a ser atualizado
     * @param entity DTO do pedido com os dados atualizados
     * @return DTO do pedido atualizado
     */

    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto update(Integer id, ProdutoDto entity) {
        log.info("ProdutoService::update - Atualizando produto com ID: {}", id);
        ProdutoModel produtoModel = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado"));

        produtoMapper.updateEntityFromDTO(entity, produtoModel);
        ProdutoModel produtoAtualizado = produtoRepository.save(produtoModel);
        return produtoMapper.toDTO(produtoAtualizado);
    }

    /**
     * Deleta um pedido com base no identificador informado.
     *
     * @param id ID do pedido a ser deletado
     */

    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ProdutoService::delete - Deletando produto com ID: {}", id);
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto com ID " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
