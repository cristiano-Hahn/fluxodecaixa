package br.com.fluxodecaixa.application;

import br.com.fluxodecaixa.domain.model.Venda;
import br.com.fluxodecaixa.domain.model.VendaItem;
import br.com.fluxodecaixa.domain.service.produto.BuscarProduto;
import br.com.fluxodecaixa.domain.service.venda.BuscarVenda;
import br.com.fluxodecaixa.domain.service.venda.CriarVenda;
import br.com.fluxodecaixa.domain.service.venda.ExcluirVenda;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import br.com.fluxodecaixa.interfaces.transfer.venda.VendaDto;
import br.com.fluxodecaixa.interfaces.transfer.venda.VendaItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class VendaService {

    private final BuscarProduto buscarProduto;
    private final CriarVenda criarVenda;
    private final BuscarVenda buscarVenda;
    private final ExcluirVenda excluirVenda;

    @Autowired
    public VendaService(BuscarProduto buscarProduto,
                        CriarVenda criarVenda,
                        BuscarVenda buscarVenda,
                        ExcluirVenda excluirVenda) {
        this.buscarProduto = buscarProduto;
        this.criarVenda = criarVenda;
        this.buscarVenda = buscarVenda;
        this.excluirVenda = excluirVenda;
    }


    public IdDto criarVenda(VendaDto vendaDto) {
        Venda venda = new Venda();
        venda.setData(vendaDto.getData());
        venda.setDescricao(vendaDto.getDescricao());
        venda.setMeioPagamento(vendaDto.getMeioPagamento());

        for (VendaItemDto itemDto : vendaDto.getItens()) {
            VendaItem item = new VendaItem();
            item.setProduto(buscarProduto.executar(itemDto.getProdutoId()));
            item.setQuantidade(itemDto.getQuantidade());
            venda.getItens().add(item);
        }
        return new IdDto(criarVenda.executar(venda).getId());
    }

    public VendaDto buscarVenda(UUID id) {
        Venda venda = buscarVenda.executar(id);
        VendaDto result = new VendaDto();
        result.setId(venda.getId());
        result.setData(venda.getData());
        result.setDescricao(venda.getDescricao());
        result.setMeioPagamento(venda.getMeioPagamento());
        result.setItens(new ArrayList<>());

        for (VendaItem item : venda.getItens()) {
            VendaItemDto itemDto = new VendaItemDto();
            itemDto.setProdutoId(item.getProduto().getId());
            itemDto.setQuantidade(item.getQuantidade());
            result.getItens().add(itemDto);
        }
        return result;
    }

    public void excluirVenda(UUID id) {
        excluirVenda.executar(id);
    }
}
