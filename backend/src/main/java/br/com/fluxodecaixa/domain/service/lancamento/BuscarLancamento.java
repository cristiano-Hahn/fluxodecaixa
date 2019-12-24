package br.com.fluxodecaixa.domain.service.lancamento;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Lancamento;
import br.com.fluxodecaixa.domain.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarLancamento {

    private LancamentoRepository lancamentoRepository;

    @Autowired
    public BuscarLancamento(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento executar(UUID id) {
        Optional<Lancamento> optionalLancamento = lancamentoRepository.findById(id);
        if (optionalLancamento.isEmpty()) {
            throw new RecursoNaoEncontradoException("lançamento", id);
        }
        return optionalLancamento.get();
    }

}
