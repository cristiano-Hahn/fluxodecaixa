package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProduto {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public CriarProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto executar(Produto values) {
        return produtoRepository.save(values);
    }

}
