package com.gabrieltonhatti.crudapi.domain.exception;

public class VendaException extends RuntimeException {

    public VendaException(String message) {
        super(message);
    }

    public VendaException(Long id) {
        this(String.format("Não existe venda com o código %s em nosso sistema!", id));
    }

}
