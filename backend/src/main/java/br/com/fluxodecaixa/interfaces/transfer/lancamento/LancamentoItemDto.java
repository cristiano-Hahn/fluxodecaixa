package br.com.fluxodecaixa.interfaces.transfer.lancamento;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class LancamentoItemDto implements Serializable {

    @NotNull
    UUID produtoId;

    @NotNull
    Double quantidade;
}
