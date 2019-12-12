package br.com.fluxodecaixa.domain.service.venda;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Produto;
import br.com.fluxodecaixa.domain.model.Venda;
import br.com.fluxodecaixa.domain.repository.ProdutoRepository;
import br.com.fluxodecaixa.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExcluirVenda {

    private final VendaRepository vendaRepository;

    @Autowired
    public ExcluirVenda(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public void executar(UUID id) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        if (optionalVenda.isEmpty()) {
            throw new RecursoNaoEncontradoException("venda", id);
        }
        vendaRepository.delete(optionalVenda.get());
    }

}
