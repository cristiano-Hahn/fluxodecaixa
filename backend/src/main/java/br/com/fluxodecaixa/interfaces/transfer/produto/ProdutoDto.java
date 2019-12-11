package br.com.fluxodecaixa.interfaces.transfer.produto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
public class ProdutoDto implements Serializable {

    UUID id;

    @NotNull
    Integer codigo;

    @Size(max = 100)
    @NotEmpty
    String nome;

    @NotNull
    Double precoCusto;

    @NotNull
    Double precoVenda;

    @Size(max = 1000)
    String observacao;
}
