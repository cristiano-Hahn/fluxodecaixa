package br.com.fluxodecaixa.domain.service.lancamento;

import br.com.fluxodecaixa.domain.exception.RecursoNaoEncontradoException;
import br.com.fluxodecaixa.domain.model.Lancamento;
import br.com.fluxodecaixa.domain.model.LancamentoItem;
import br.com.fluxodecaixa.domain.model.enums.TipoLancamento;
import br.com.fluxodecaixa.domain.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarLancamento {

    private final LancamentoRepository lancamentoRepository;

    @Autowired
    public AtualizarLancamento(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento executar(UUID id, Lancamento values) {
        Optional<Lancamento> optionalLancamento = lancamentoRepository.findById(id);
        if (optionalLancamento.isEmpty()) {
            throw new RecursoNaoEncontradoException("produto", id);
        }
        Lancamento lancamento = optionalLancamento.get();
        lancamento.setData(values.getData());
        lancamento.setDataPagamento(values.getDataPagamento());
        lancamento.setMeioPagamento(values.getMeioPagamento());
        lancamento.setTipoLancamento(values.getTipoLancamento());
        lancamento.setObservacao(values.getObservacao());
        lancamento.getItens().clear();

        for (LancamentoItem item: values.getItens()){
            lancamento.getItens().add(item);
        }

        if (values.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
            lancamento.setValor((double) 0);
            for (LancamentoItem item : values.getItens()) {
                lancamento.setValor(lancamento.getValor() + (item.getProduto().getPrecoVenda() * item.getQuantidade()));
            }
        } else {
            lancamento.setValor(values.getValor());
        }

        return lancamentoRepository.save(lancamento);
    }

}
