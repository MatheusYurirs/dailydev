package br.com.yuri.dailydev.advice;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse{
    private int status;
    private String mensagem;
    private Map<String, String> erros;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String mensagem, Map<String, String> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.erros = erros;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Map<String, String> getErros() {
        return erros;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
