package com.gabrieltonhatti.crudapi.domain.exception;

public class VendedorException extends RuntimeException {

    public VendedorException(String message) {
        super(message);
    }

    public VendedorException(Long id) {
        this(String.format("Não existe vendedor com o código %s em nosso sistema!", id));
    }

}
