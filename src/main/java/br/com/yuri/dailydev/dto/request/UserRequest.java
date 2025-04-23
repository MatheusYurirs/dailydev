package br.com.yuri.dailydev.dto.request;

public record UserRequest(Long id,
                          String name,
                          String email,
                          String password) {
}
