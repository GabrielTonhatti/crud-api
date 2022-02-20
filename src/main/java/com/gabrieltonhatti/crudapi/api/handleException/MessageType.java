package com.gabrieltonhatti.crudapi.api.handleException;

import lombok.Getter;

@Getter
public enum MessageType {

    RECURSO_NAO_ENCONTRADA("/recurso-nao-encontrada", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de Negócio");

    private final String title;
    private final String uri;

    MessageType(String path, String title) {
        this.uri = "https://crud-api" + path;
        this.title = title;
    }

}
