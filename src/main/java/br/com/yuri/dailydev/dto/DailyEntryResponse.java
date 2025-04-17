package br.com.yuri.dailydev.dto;

import br.com.yuri.dailydev.model.enums.HumorDoDia;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyEntryResponse {
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    private int horasEstudadas;
    private HumorDoDia humor;
    private String tecnologiasEstudadas;
    private String desafios;
    private String anotacoes;

    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public DailyEntryResponse(Long id, LocalDate data, int horasEstudadas, HumorDoDia humor, String tecnologiasEstudadas, String desafios, String anotacoes, LocalDateTime criadoEm) {
        this.id = id;
        this.data = data;
        this.horasEstudadas = horasEstudadas;
        this.humor = humor;
        this.tecnologiasEstudadas = tecnologiasEstudadas;
        this.desafios = desafios;
        this.anotacoes = anotacoes;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getHorasEstudadas() {
        return horasEstudadas;
    }

    public void setHorasEstudadas(int horasEstudadas) {
        this.horasEstudadas = horasEstudadas;
    }

    public HumorDoDia getHumor() {
        return humor;
    }

    public void setHumor(HumorDoDia humor) {
        this.humor = humor;
    }

    public String getTecnologiasEstudadas() {
        return tecnologiasEstudadas;
    }

    public void setTecnologiasEstudadas(String tecnologiasEstudadas) {
        this.tecnologiasEstudadas = tecnologiasEstudadas;
    }

    public String getDesafios() {
        return desafios;
    }

    public void setDesafios(String desafios) {
        this.desafios = desafios;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
