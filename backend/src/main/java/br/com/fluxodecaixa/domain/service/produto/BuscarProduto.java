package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarProduto {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public BuscarProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto executar(UUID id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isEmpty()) {
            throw new RecursoNaoEncontradoException("produto",id);
        }
        return optionalProduto.get();
    }

}
