package com.gabrieltonhatti.crudapi.api.handleException;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Message {

    private String type;
    private String title;
    private String message;
    private Integer status;
    private List<Field> fields;
    private LocalDateTime timestamp;

    @Getter
    @Setter
    public static class Field {

        private String name;
        private String message;

    }

}
