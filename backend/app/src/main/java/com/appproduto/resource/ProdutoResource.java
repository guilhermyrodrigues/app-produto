package com.appproduto.resource;

import com.appproduto.dto.ProdutoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/produtos")
public class ProdutoResource {

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProdutoDto create(@RequestBody ProdutoDto entity) {
        log.info("ProdutoResource::create");
        log.debug("Valores: {}", entity);
        return
    }

    @GetMapping(value = "{/id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProdutoDto get(@PathVariable Integer id) {
        log.info("ProdutoResource::get");
        log.debug("Valores: {}", id);
        return
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProdutoDto> get() {
        log.info("ProdutoResource::get");
        log.debug("Valores: sem parâmetro");
        return
    }

    @PutMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ProdutoDto update(@PathVariable Integer id, @RequestBody ProdutoDto entity) {
        log.info("ProdutoResource::update");
        log.debug("Valores: {} e {}", id, entity);
        return
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("ProdutoResource::delete");
        log.debug("Valores: {}", id);

    }



}
