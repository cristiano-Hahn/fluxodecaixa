package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.exception.ProdutoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarProduto {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public AtualizarProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto executar(UUID id, Produto values) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isEmpty()) {
            throw new ProdutoNaoEncontradoException(id);
        }
        Produto produto = optionalProduto.get();
        produto.setObservacao(values.getObservacao());
        produto.setPrecoVenda(values.getPrecoVenda());
        produto.setPrecoCusto(values.getPrecoCusto());
        produto.setNome(values.getNome());
        produto.setCodigo(values.getCodigo());

        return produtoRepository.save(produto);
    }

}
