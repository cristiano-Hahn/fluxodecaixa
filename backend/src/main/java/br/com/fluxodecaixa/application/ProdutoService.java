package br.com.fluxodecaixa.application;

import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.service.produto.*;
import br.com.fluxodecaixa.interfaces.transfer.produto.ProdutoDto;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    private final CriarProduto criarProduto;
    private final AtualizarProduto atualizarProduto;
    private final ExcluirProduto excluirProduto;
    private final BuscarProduto buscarProduto;
    private final BuscarTodosProdutos buscarTodosProdutos;

    @Autowired
    public ProdutoService(CriarProduto criarProduto,
                          AtualizarProduto atualizarProduto,
                          ExcluirProduto excluirProduto,
                          BuscarProduto buscarProduto,
                          BuscarTodosProdutos buscarTodosProdutos) {
        this.criarProduto = criarProduto;
        this.atualizarProduto = atualizarProduto;
        this.excluirProduto = excluirProduto;
        this.buscarProduto = buscarProduto;
        this.buscarTodosProdutos = buscarTodosProdutos;
    }

    public IdDto criarProduto(ProdutoDto produtoDto) {
        Produto values = new Produto();
        values.setCodigo(produtoDto.getCodigo());
        values.setNome(produtoDto.getNome());
        values.setPrecoCusto(produtoDto.getPrecoCusto());
        values.setPrecoVenda(produtoDto.getPrecoVenda());
        values.setObservacao(produtoDto.getObservacao());

        return new IdDto(criarProduto.executar(values).getId());
    }

    public void atualizarProduto(UUID id, ProdutoDto produtoDto) {
        Produto values = new Produto();
        values.setCodigo(produtoDto.getCodigo());
        values.setNome(produtoDto.getNome());
        values.setPrecoCusto(produtoDto.getPrecoCusto());
        values.setPrecoVenda(produtoDto.getPrecoVenda());
        values.setObservacao(produtoDto.getObservacao());

        atualizarProduto.executar(id, values);
    }

    public void excluirProduto(UUID id) {
        excluirProduto.executar(id);
    }

    public ProdutoDto buscarProduto(UUID id) {
        Produto produto = buscarProduto.executar(id);

        ProdutoDto result = new ProdutoDto();
        result.setId(produto.getId());
        result.setCodigo(produto.getCodigo());
        result.setNome(produto.getNome());
        result.setPrecoCusto(produto.getPrecoCusto());
        result.setPrecoVenda(produto.getPrecoVenda());
        result.setObservacao(produto.getObservacao());
        return result;
    }

    public List<ProdutoDto> buscarTodosProdutos(String filtro) {
        List<Produto> produtos = buscarTodosProdutos.executar(filtro);

        List<ProdutoDto> result = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setId(produto.getId());
            produtoDto.setCodigo(produto.getCodigo());
            produtoDto.setNome(produto.getNome());
            produtoDto.setPrecoCusto(produto.getPrecoCusto());
            produtoDto.setPrecoVenda(produto.getPrecoVenda());
            produtoDto.setObservacao(produto.getObservacao());
            result.add(produtoDto);
        }
        return result;
    }
}
