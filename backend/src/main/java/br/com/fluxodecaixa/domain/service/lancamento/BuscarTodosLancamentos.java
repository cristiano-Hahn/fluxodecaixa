package br.com.fluxodecaixa.domain.service.lancamento;

import br.com.fluxodecaixa.domain.model.Lancamento;
import br.com.fluxodecaixa.domain.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BuscarTodosLancamentos {

    private final LancamentoRepository lancamentoRepository;

    @Autowired
    public BuscarTodosLancamentos(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Lancamento> executar(Date dataInicial, Date dataFinal) {
        return lancamentoRepository.findByDataBetween(dataInicial, dataFinal);
    }

}
