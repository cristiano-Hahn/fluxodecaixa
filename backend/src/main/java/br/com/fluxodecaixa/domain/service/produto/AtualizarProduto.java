package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarProduto {

    private final ProdutoRepository produtoRepository;
    private final CalcularMargemLucro calcularMargemLucro;

    @Autowired
    public AtualizarProduto(ProdutoRepository produtoRepository, CalcularMargemLucro calcularMargemLucro) {
        this.produtoRepository = produtoRepository;
        this.calcularMargemLucro = calcularMargemLucro;
    }

    public Produto executar(UUID id, Produto values) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isEmpty()) {
            throw new RecursoNaoEncontradoException("produto", id);
        }
        Produto produto = optionalProduto.get();
        produto.setObservacao(values.getObservacao());
        produto.setPrecoVenda(values.getPrecoVenda());
        produto.setPrecoCusto(values.getPrecoCusto());
        produto.setMargemLucro(calcularMargemLucro.executar(values.getPrecoCusto(), values.getPrecoVenda()));
        produto.setNome(values.getNome());

        return produtoRepository.save(produto);
    }

}
