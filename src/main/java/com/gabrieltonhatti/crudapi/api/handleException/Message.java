package com.gabrieltonhatti.crudapi.api.handleException;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Message {

    private String message;
    private Integer status;
    private LocalDateTime date;

}
