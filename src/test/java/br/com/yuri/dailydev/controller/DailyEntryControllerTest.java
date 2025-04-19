package br.com.yuri.dailydev.controller;

import br.com.yuri.dailydev.dto.DailyEntryRequest;
import br.com.yuri.dailydev.mapper.DailyEntryMapper;
import br.com.yuri.dailydev.model.DailyEntry;
import br.com.yuri.dailydev.model.enums.HumorDoDia;
import br.com.yuri.dailydev.service.DailyEntryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DailyEntryController.class) // Foca só no controller
class DailyEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DailyEntryService dailyEntryService; // Mock do serviço

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddDailyEntry_ReturnsCreated() throws Exception {
        // Criando a requisição simulada
        DailyEntryRequest request = new DailyEntryRequest();
        request.setData(LocalDate.of(2025, 4, 17));
        request.setHorasEstudadas(3);
        request.setHumor(HumorDoDia.FELIZ);
        request.setTecnologiasEstudadas("Java, Spring");
        request.setDesafios("Fazer testes com MockMvc");
        request.setAnotacoes("Primeiro teste de Controller!");

        // Convertendo pra JSON
        String jsonBody = objectMapper.writeValueAsString(request);

        // Executando chamada simulada ao POST
        mockMvc.perform(post("/dailyentry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetAllDailyEntries_ReturnsList() throws Exception {
        // Criando entradas simuladas
        DailyEntry entry1 = new DailyEntry();
        entry1.setId(1L);
        entry1.setData(LocalDate.of(2025, 4, 17));
        entry1.setHorasEstudadas(2);
        entry1.setHumor(HumorDoDia.FELIZ);
        entry1.setTecnologiasEstudadas("Java");
        entry1.setDesafios("Testar com MockMvc");
        entry1.setAnotacoes("Primeiro retorno!");

        DailyEntry entry2 = new DailyEntry();
        entry2.setId(2L);
        entry2.setData(LocalDate.of(2025, 4, 18));
        entry2.setHorasEstudadas(4);
        entry2.setHumor(HumorDoDia.MOTIVADO);
        entry2.setTecnologiasEstudadas("Spring");
        entry2.setDesafios("Testar Controller");
        entry2.setAnotacoes("Segundo retorno!");

        // Simulando retorno do service
        List<DailyEntry> mockEntries = List.of(entry1, entry2);
        when(dailyEntryService.findAllEntities()).thenReturn(mockEntries);

        // Executando requisição e validando resultado
        mockMvc.perform(get("/dailyentry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].tecnologiasEstudadas").value("Java"))
                .andExpect(jsonPath("$[1].tecnologiasEstudadas").value("Spring"));
    }

    @Test
    void testGetDailyEntryById_ReturnsEntry() throws Exception {
        Long id = 1L;

        DailyEntry entry = new DailyEntry();
        entry.setId(id);
        entry.setData(LocalDate.of(2025, 4, 17));
        entry.setHorasEstudadas(4);
        entry.setHumor(HumorDoDia.MOTIVADO);
        entry.setTecnologiasEstudadas("Spring Boot");
        entry.setDesafios("Dominar testes");
        entry.setAnotacoes("Esse é um teste de busca por ID");

        when(dailyEntryService.findById(id)).thenReturn(entry);

        mockMvc.perform(get("/dailyentry/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.tecnologiasEstudadas").value("Spring Boot"))
                .andExpect(jsonPath("$.desafios").value("Dominar testes"));
    }

    @Test
    void testUpdateDailyEntry_ReturnsUpdatedEntry() throws Exception {
        Long id = 1L;

        // Criando a requisição simulada
        DailyEntryRequest request = new DailyEntryRequest();
        request.setData(LocalDate.of(2025, 4, 17));
        request.setHorasEstudadas(3);
        request.setHumor(HumorDoDia.FELIZ);
        request.setTecnologiasEstudadas("JUnit, Mockito");
        request.setDesafios("Simular PUT com sucesso");
        request.setAnotacoes("Primeiro teste de update!");

        String jsonBody = objectMapper.writeValueAsString(request);

        // Simulando retorno do service
        DailyEntry updatedEntry = DailyEntryMapper.toEntity(request);

        when(dailyEntryService.updateById(eq(id), any(DailyEntry.class))).thenReturn(updatedEntry);

        // Executa a chamada simulada
        mockMvc.perform(put("/dailyentry/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tecnologiasEstudadas").value("JUnit, Mockito"));
    }

    @Test
    void testDeleteDailyEntryById_ReturnsNoContent() throws Exception {
        // ID existente
        Long id = 1L;

        // Simulando comportamento do service
        doNothing().when(dailyEntryService).deleteById(id);

        // Executando a chamada simulada
        mockMvc.perform(delete("/dailyentry/{id}", id))
                .andExpect(status().isNoContent());
    }





}
