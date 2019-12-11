package br.com.fluxodecaixa.domain.exception;

import java.util.UUID;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException(UUID id) {
        super("Não foi possível encontrar o produto com o identificador ".concat(id.toString()));
    }
}
