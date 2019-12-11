package br.com.fluxodecaixa.domain.exception;

import java.util.UUID;

public class CategoriaNaoEncontradaException extends RuntimeException{
    public CategoriaNaoEncontradaException(UUID categoriaId) {
        super("Não foi possível encontrar a categoria com o Identificador ".concat(categoriaId.toString()));
    }
}
