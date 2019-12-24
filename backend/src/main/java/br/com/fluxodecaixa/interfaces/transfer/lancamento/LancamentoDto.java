package br.com.fluxodecaixa.interfaces.transfer.lancamento;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import br.com.fluxodecaixa.domain.model.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class LancamentoDto implements Serializable {

    UUID id;

    @NotNull
    @JsonFormat(lenient = OptBoolean.FALSE)
    Date data;

    @JsonFormat(lenient = OptBoolean.FALSE)
    Date dataPagamento;

    @NotNull
    TipoLancamento tipoLancamento;

    @NotNull
    MeioPagamento meioPagamento;

    @Size(max = 500)
    String observacao;

    Double valor;

    @Valid
    List<LancamentoItemDto> itens;
}
