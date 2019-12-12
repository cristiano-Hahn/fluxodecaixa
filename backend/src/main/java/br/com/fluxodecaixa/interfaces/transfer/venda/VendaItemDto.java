package br.com.fluxodecaixa.interfaces.transfer.venda;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class VendaItemDto implements Serializable {
    @NotNull
    UUID produtoId;

    @NotNull
    Double quantidade;
}