package br.com.fluxodecaixa.domain.exception;

import java.util.UUID;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(String recurso, UUID id) {
        super("Não foi possível encontrar o campo ".concat(recurso).concat(" com o identificador ").concat(id.toString()));
    }
}
