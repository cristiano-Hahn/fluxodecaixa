package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProduto {

    private final ProdutoRepository produtoRepository;
    private final CalcularMargemLucro calcularMargemLucro;

    @Autowired
    public CriarProduto(ProdutoRepository produtoRepository,
                        CalcularMargemLucro calcularMargemLucro) {
        this.produtoRepository = produtoRepository;
        this.calcularMargemLucro = calcularMargemLucro;
    }

    public Produto executar(Produto values) {
        values.setMargemLucro(calcularMargemLucro.executar(values.getPrecoCusto(), values.getPrecoVenda()));
        return produtoRepository.save(values);
    }

}
