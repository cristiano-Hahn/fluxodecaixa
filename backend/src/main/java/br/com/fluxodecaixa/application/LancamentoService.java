package br.com.fluxodecaixa.application;

import br.com.fluxodecaixa.domain.model.Lancamento;
import br.com.fluxodecaixa.domain.model.LancamentoItem;
import br.com.fluxodecaixa.domain.service.lancamento.*;
import br.com.fluxodecaixa.domain.service.produto.BuscarProduto;
import br.com.fluxodecaixa.interfaces.transfer.lancamento.LancamentoDto;
import br.com.fluxodecaixa.interfaces.transfer.lancamento.LancamentoItemDto;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LancamentoService {

    private final BuscarProduto buscarProduto;
    private final CriarLancamento criarLancamento;
    private final BuscarLancamento buscarLancamento;
    private final ExcluirLancamento excluirLancamento;
    private final BuscarTodosLancamentos buscarTodosLancamentos;
    private final AtualizarLancamento atualizarLancamento;

    @Autowired
    public LancamentoService(BuscarProduto buscarProduto,
                             CriarLancamento criarLancamento,
                             BuscarLancamento buscarLancamento,
                             ExcluirLancamento excluirLancamento,
                             BuscarTodosLancamentos buscarTodosLancamentos,
                             AtualizarLancamento atualizarLancamento) {
        this.buscarProduto = buscarProduto;
        this.criarLancamento = criarLancamento;
        this.buscarLancamento = buscarLancamento;
        this.excluirLancamento = excluirLancamento;
        this.buscarTodosLancamentos = buscarTodosLancamentos;
        this.atualizarLancamento = atualizarLancamento;
    }


    public IdDto criarLancamento(LancamentoDto lancamentoDto) {
        Lancamento lancamento = new Lancamento();
        lancamento.setData(lancamentoDto.getData());
        lancamento.setDataPagamento(lancamentoDto.getDataPagamento());
        lancamento.setValor(lancamentoDto.getValor());
        lancamento.setTipoLancamento(lancamentoDto.getTipoLancamento());
        lancamento.setMeioPagamento(lancamentoDto.getMeioPagamento());
        lancamento.setObservacao(lancamentoDto.getObservacao());

        for (LancamentoItemDto itemDto : lancamentoDto.getItens()) {
            LancamentoItem item = new LancamentoItem();
            item.setProduto(buscarProduto.executar(itemDto.getProdutoId()));
            item.setQuantidade(itemDto.getQuantidade());
            lancamento.getItens().add(item);
        }
        return new IdDto(criarLancamento.executar(lancamento).getId());
    }

    public void atualizarLancamento(UUID id, LancamentoDto lancamentoDto) {
        Lancamento lancamento = new Lancamento();
        lancamento.setData(lancamentoDto.getData());
        lancamento.setDataPagamento(lancamentoDto.getDataPagamento());
        lancamento.setValor(lancamentoDto.getValor());
        lancamento.setTipoLancamento(lancamentoDto.getTipoLancamento());
        lancamento.setMeioPagamento(lancamentoDto.getMeioPagamento());
        lancamento.setObservacao(lancamentoDto.getObservacao());

        for (LancamentoItemDto itemDto : lancamentoDto.getItens()) {
            LancamentoItem item = new LancamentoItem();
            item.setProduto(buscarProduto.executar(itemDto.getProdutoId()));
            item.setQuantidade(itemDto.getQuantidade());
            lancamento.getItens().add(item);
        }
        atualizarLancamento.executar(id, lancamento);
    }

    public void excluirLancamento(UUID id) {
        excluirLancamento.executar(id);
    }

    public LancamentoDto buscarLancamento(UUID id) {
        Lancamento lancamento = buscarLancamento.executar(id);
        LancamentoDto result = new LancamentoDto();
        result.setId(lancamento.getId());
        result.setData(lancamento.getData());
        result.setDataPagamento(lancamento.getDataPagamento());
        result.setMeioPagamento(lancamento.getMeioPagamento());
        result.setTipoLancamento(lancamento.getTipoLancamento());
        result.setObservacao(lancamento.getObservacao());
        result.setValor(lancamento.getValor());
        result.setItens(new ArrayList<>());

        for (LancamentoItem item : lancamento.getItens()) {
            LancamentoItemDto itemDto = new LancamentoItemDto();
            itemDto.setProdutoId(item.getProduto().getId());
            itemDto.setQuantidade(item.getQuantidade());
            result.getItens().add(itemDto);
        }
        return result;
    }

    public List<LancamentoDto> buscarTodosLancamentos(Date dataInicial, Date dataFinal) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataFinal);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        Date dataFinalOficial = calendar.getTime();

        List<Lancamento> lancamentos = buscarTodosLancamentos.executar(dataInicial, dataFinalOficial);
        List<LancamentoDto> result = new ArrayList<>();

        for (Lancamento lancamento : lancamentos) {
            LancamentoDto lancamentoDto = new LancamentoDto();
            lancamentoDto.setId(lancamento.getId());
            lancamentoDto.setData(lancamento.getData());
            lancamentoDto.setDataPagamento(lancamento.getDataPagamento());
            lancamentoDto.setMeioPagamento(lancamento.getMeioPagamento());
            lancamentoDto.setTipoLancamento(lancamento.getTipoLancamento());
            lancamentoDto.setObservacao(lancamento.getObservacao());
            lancamentoDto.setValor(lancamento.getValor());
            lancamentoDto.setItens(new ArrayList<>());

            for (LancamentoItem item : lancamento.getItens()) {
                LancamentoItemDto itemDto = new LancamentoItemDto();
                itemDto.setProdutoId(item.getProduto().getId());
                itemDto.setQuantidade(item.getQuantidade());
                lancamentoDto.getItens().add(itemDto);
            }
            result.add(lancamentoDto);
        }
        return result;
    }


}
