package com.gabrieltonhatti.crudapi.api.handleException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.gabrieltonhatti.crudapi.domain.exception.VendaException;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. " +
            "Tente novamente e se o problema persistir, entre em contato com o administrador do sistema";


    @ExceptionHandler(VendedorException.class)
    public ResponseEntity<?> handleVendedor(VendedorException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MessageType messageType = MessageType.RECURSO_NAO_ENCONTRADA;
        String detail = ex.getMessage();

        Message message = createMessage(status, messageType, detail).build();

        return handleExceptionInternal(ex, message, new HttpHeaders(), status, request);

    }

    @ExceptionHandler(VendaException.class)
    public ResponseEntity<?> handleVenda(VendaException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MessageType messageType = MessageType.RECURSO_NAO_ENCONTRADA;
        String detail = ex.getMessage();

        Message message = createMessage(status, messageType, detail).build();

        return handleExceptionInternal(ex, message, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if(body == null) {
            body = Message
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        } else if(body instanceof String) {
            body = Message
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Message.MessageBuilder createMessage(HttpStatus status, MessageType messageType, String message) {
        return Message
                .builder()
                .message(message)
                .status(status.value())
                .type(messageType.getUri())
                .title(messageType.getTitle())
                .timestamp(LocalDateTime.now());
    }

    private String joinPath(List<JsonMappingException.Reference> references) {
        return references
                .stream()
                .map(JsonMappingException.Reference::getFieldName)
                .collect(Collectors.joining());
    }


}
