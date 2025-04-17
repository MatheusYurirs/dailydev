package br.com.yuri.dailydev.service;

import br.com.yuri.dailydev.exception.ResourceNotFoundException;
import br.com.yuri.dailydev.model.DailyEntry;
import br.com.yuri.dailydev.repository.DailyEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyEntryService {


    private final DailyEntryRepository dailyEntryRepository;


    public DailyEntryService(DailyEntryRepository dailyEntryRepository) {
        this.dailyEntryRepository = dailyEntryRepository;
    }


    public DailyEntry saveEntity(DailyEntry dailyEntry){
       return dailyEntryRepository.save(dailyEntry);
    }

    public List<DailyEntry> findAllEntities(){
        return dailyEntryRepository.findAll();
    }

    public DailyEntry findById(Long id){
        return dailyEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrada diária com ID " + id + " não encontrada."));
    }

    public DailyEntry updateById(Long id, DailyEntry updatedEntry){
           DailyEntry entryExist = findById(id);
            entryExist.setData(updatedEntry.getData());
            entryExist.setHorasEstudadas(updatedEntry.getHorasEstudadas());
            entryExist.setHumor(updatedEntry.getHumor());
            entryExist.setTecnologiasEstudadas(updatedEntry.getTecnologiasEstudadas());
            entryExist.setDesafios(updatedEntry.getDesafios());
            entryExist.setAnotacoes(updatedEntry.getAnotacoes());

            return dailyEntryRepository.save(entryExist);
    }

    public void deleteById(Long id){
        if(!dailyEntryRepository.existsById(id)){
            throw new ResourceNotFoundException("Entrada diária com ID " + id + " não encontrada.");
        }
        dailyEntryRepository.deleteById(id);
    }
}
