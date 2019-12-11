package br.com.fluxodecaixa.domain.exception;

public class CodigoCategoriaJaExisteException extends RuntimeException {
    public CodigoCategoriaJaExisteException(Integer codigo) {
        super("Já existe uma categoria com o código ".concat(codigo.toString()));
    }
}
