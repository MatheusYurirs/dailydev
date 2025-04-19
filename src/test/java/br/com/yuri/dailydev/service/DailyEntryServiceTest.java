
package br.com.yuri.dailydev.service;

import br.com.yuri.dailydev.exception.ResourceNotFoundException;
import br.com.yuri.dailydev.model.DailyEntry;
import br.com.yuri.dailydev.repository.DailyEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DailyEntryServiceTest {

    @Mock
    private DailyEntryRepository dailyEntryRepository;

    @InjectMocks
    private DailyEntryService dailyEntryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_ReturnsEntry_WhenIdExists() {
        Long id = 1L;
        DailyEntry entry = new DailyEntry();
        entry.setId(id);
        entry.setData(LocalDate.of(2025, 4, 17));
        entry.setHorasEstudadas(4);
        entry.setTecnologiasEstudadas("Java, Spring Boot");

        when(dailyEntryRepository.findById(id)).thenReturn(Optional.of(entry));

        DailyEntry result = dailyEntryService.findById(id);

        assertEquals(entry.getId(), result.getId());
        assertEquals(entry.getData(), result.getData());
        assertEquals(entry.getHorasEstudadas(), result.getHorasEstudadas());
        assertEquals(entry.getTecnologiasEstudadas(), result.getTecnologiasEstudadas());

        verify(dailyEntryRepository, times(1)).findById(id);
    }

    @Test
    public void testFindById_ThrowsException_WhenIdDoesNotExist() {
        Long id = 999L;

        when(dailyEntryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> dailyEntryService.findById(id));
    }

    @Test
    public void testSaveEntity_ReturnsSavedEntry() {
        DailyEntry entryToSave = new DailyEntry();
        entryToSave.setTecnologiasEstudadas("Java e Spring");

        DailyEntry savedEntry = new DailyEntry();
        savedEntry.setId(1L);
        savedEntry.setTecnologiasEstudadas("Java e Spring");

        when(dailyEntryRepository.save(entryToSave)).thenReturn(savedEntry);

        DailyEntry result = dailyEntryService.saveEntity(entryToSave);

        assertNotNull(result);
        assertEquals(savedEntry.getId(), result.getId());
        assertEquals("Java e Spring", result.getTecnologiasEstudadas());
    }

    @Test
    public void testUpdateById_ReturnsUpdatedEntry() {
        Long id = 1L;

        DailyEntry existingEntry = new DailyEntry();
        existingEntry.setId(id);
        existingEntry.setTecnologiasEstudadas("Antes");

        DailyEntry updatedEntry = new DailyEntry();
        updatedEntry.setTecnologiasEstudadas("Depois");

        // Mock do findById retornando o existente
        when(dailyEntryRepository.findById(id)).thenReturn(Optional.of(existingEntry));

        // Mock do save retornando o mesmo objeto (já modificado)
        when(dailyEntryRepository.save(any(DailyEntry.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Optional<DailyEntry> result = Optional.ofNullable(dailyEntryService.updateById(id, updatedEntry));

        assertTrue(result.isPresent());
        assertEquals("Depois", result.get().getTecnologiasEstudadas());
    }

    @Test
    public void testDeleteById_ThrowsException_WhenIdDoesNotExist() {
        Long id = 2L;

        when(dailyEntryRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            dailyEntryService.deleteById(id);
        });

        verify(dailyEntryRepository, times(1)).existsById(id);
    }


}
