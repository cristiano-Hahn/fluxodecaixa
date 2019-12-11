package br.com.fluxodecaixa.domain.service.produto;

import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosProdutos {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public BuscarTodosProdutos(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> executar(String filtro) {
        if (filtro == null) {
            return produtoRepository.findByNomeContainingIgnoreCaseOrCodigo("", 0);
        } else {
            Integer codigo = 0;
            try {
                codigo = Integer.parseInt(filtro);
            } catch (NumberFormatException ignored) {
            }
            return produtoRepository.findByNomeContainingIgnoreCaseOrCodigo(filtro, codigo);
        }

    }

}
