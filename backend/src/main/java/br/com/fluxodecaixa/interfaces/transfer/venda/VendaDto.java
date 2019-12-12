package br.com.fluxodecaixa.interfaces.transfer.venda;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class VendaDto implements Serializable {
    UUID id;

    @NotNull
    Date data;

    @NotNull
    MeioPagamento meioPagamento;

    String descricao;

    @Valid
    @NotNull
    List<VendaItemDto> itens;
}