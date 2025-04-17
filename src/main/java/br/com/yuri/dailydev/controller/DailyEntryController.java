package br.com.yuri.dailydev.controller;

import br.com.yuri.dailydev.dto.DailyEntryRequest;
import br.com.yuri.dailydev.dto.DailyEntryResponse;
import br.com.yuri.dailydev.mapper.DailyEntryMapper;
import br.com.yuri.dailydev.model.DailyEntry;
import br.com.yuri.dailydev.service.DailyEntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailyentry")
@Tag(name = "Daily Entry", description = "Gerencia os registros diários do desenvolvedor")
public class DailyEntryController {

    private final DailyEntryService dailyEntryService;

    public DailyEntryController(DailyEntryService dailyEntryService) {
        this.dailyEntryService = dailyEntryService;
    }

    @Operation(
            summary = "Criar uma nova entrada",
            description = "Cria um novo registro com data, humor, tecnologias estudadas, desafios e anotações."
    )
    @PostMapping
    public ResponseEntity<Void> addDailyEntry(@RequestBody @Valid DailyEntryRequest request) {
        DailyEntry entry = DailyEntryMapper.toEntity(request);
        dailyEntryService.saveEntity(entry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Listar todas as entradas",
            description = "Retorna todas as entradas diárias cadastradas até o momento."
    )
    @GetMapping
    public ResponseEntity<List<DailyEntryResponse>> getAll() {
        List<DailyEntry> entries = dailyEntryService.findAllEntities();
        List<DailyEntryResponse> response = entries.stream()
                .map(DailyEntryMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Buscar entrada por ID",
            description = "Retorna uma entrada específica com base no ID informado."
    )
    @GetMapping("/{id}")
    public ResponseEntity<DailyEntryResponse> getById(@PathVariable Long id) {
        DailyEntry entry = dailyEntryService.findById(id);
        return ResponseEntity.ok(DailyEntryMapper.toResponse(entry));
    }

    @Operation(
            summary = "Atualizar entrada existente",
            description = "Atualiza os dados de uma entrada com base no ID fornecido."
    )
    @PutMapping("/{id}")
    public ResponseEntity<DailyEntryResponse> updateById(
            @PathVariable Long id,
            @RequestBody @Valid DailyEntryRequest request) {
        DailyEntry updated = dailyEntryService.updateById(id, DailyEntryMapper.toEntity(request));
        return ResponseEntity.ok(DailyEntryMapper.toResponse(updated));
    }

    @Operation(
            summary = "Deletar entrada por ID",
            description = "Remove permanentemente uma entrada do banco de dados com base no ID fornecido."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        dailyEntryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
