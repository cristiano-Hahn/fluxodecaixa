package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExcluirProduto {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ExcluirProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void executar(UUID id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isEmpty()) {
            throw new RecursoNaoEncontradoException("produto", id);
        }
        produtoRepository.delete(optionalProduto.get());
    }

}
