package com.gabrieltonhatti.crudapi.api.handleException;

import lombok.Getter;

@Getter
public enum MessageType {

    RECURSO_NAO_ENCONTRADA("/recurso-nao-encontrada", "Recurso não encontrado"),
    RECURSO_EM_USO("/recurso-em-uso", "Recurso em uso");

    private final String title;
    private final String uri;

    MessageType(String path, String title) {
        this.uri = "https://crud-api" + path;
        this.title = title;
    }

}
