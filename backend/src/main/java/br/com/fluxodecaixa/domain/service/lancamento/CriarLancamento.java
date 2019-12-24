package br.com.fluxodecaixa.domain.service.lancamento;

import br.com.fluxodecaixa.domain.model.Lancamento;
import br.com.fluxodecaixa.domain.model.LancamentoItem;
import br.com.fluxodecaixa.domain.model.enums.TipoLancamento;
import br.com.fluxodecaixa.domain.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarLancamento {

    private LancamentoRepository lancamentoRepository;

    @Autowired
    public CriarLancamento(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento executar(Lancamento values) {
        if (values.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
            values.setValor((double) 0);
            for (LancamentoItem item : values.getItens()) {
                values.setValor(values.getValor() + (item.getProduto().getPrecoVenda() * item.getQuantidade()));
            }
        }

        return lancamentoRepository.save(values);
    }

}
