package br.com.yuri.dailydev.mapper;

import br.com.yuri.dailydev.dto.request.DailyEntryRequest;
import br.com.yuri.dailydev.dto.response.DailyEntryResponse;
import br.com.yuri.dailydev.model.DailyEntry;

import java.util.List;

public class DailyEntryMapper {

    public static DailyEntry toEntity(DailyEntryRequest request){
        DailyEntry entity = new DailyEntry();

        entity.setData(request.getData());
        entity.setHorasEstudadas(request.getHorasEstudadas());
        entity.setHumor(request.getHumor());
        entity.setTecnologiasEstudadas(request.getTecnologiasEstudadas());
        entity.setDesafios(request.getDesafios());
        entity.setAnotacoes(request.getAnotacoes());
        return entity;
    }

    public static DailyEntryResponse toResponse(DailyEntry entry){

        return new DailyEntryResponse(
                entry.getId(),
                entry.getData(),
                entry.getHorasEstudadas(),
                entry.getHumor(),
                entry.getTecnologiasEstudadas(),
                entry.getDesafios(),
                entry.getAnotacoes(),
                entry.getCriadoEm()
        );
    }

    public static List<DailyEntryResponse> toResponseList(List<DailyEntry> entries) {
        return entries.stream()
                .map(DailyEntryMapper::toResponse)
                .toList();
    }

}
