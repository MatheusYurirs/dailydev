package br.com.yuri.dailydev.dto;

import br.com.yuri.dailydev.model.enums.HumorDoDia;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DailyEntryRequest {

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotNull(message = "Horas estudadas são obrigatórios")
    private int horasEstudadas;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HumorDoDia humor;

    @NotBlank(message = "Tecnologias estudadas são obrigatórias")
    private String tecnologiasEstudadas;


    private String desafios;


    private String anotacoes;

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
}
