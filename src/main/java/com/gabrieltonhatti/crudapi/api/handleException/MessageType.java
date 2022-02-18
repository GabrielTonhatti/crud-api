package com.gabrieltonhatti.crudapi.api.handleException;

import lombok.Getter;

@Getter
public enum MessageType {

    RECURSO_NAO_ENCONTRADA("/recurso-nao-encontrada", "Recurso não encontrado");

    private String title;
    private String uri;

    MessageType(String path, String title) {
        this.uri = "https://crud-api" + path;
        this.title = title;
    }

}
