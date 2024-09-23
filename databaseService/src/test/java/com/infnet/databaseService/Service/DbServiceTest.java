package com.infnet.databaseService.Service;

import com.infnet.databaseService.Domain.Tax;
import com.infnet.databaseService.Dto.TaxDto;
import com.infnet.databaseService.Repository.DbRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DbServiceTest {

    @Mock
    private DbRepository dbRepository;

    @InjectMocks
    private DbService taxService;

    private Tax tax;

    @BeforeEach
    void setUp() {
        this.tax = new Tax();
        tax.setNetSalary(4521.00);
        tax.setIrrf(479.00);
        tax.setBruteSalary(5000.0);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        when(dbRepository.save(any(Tax.class))).thenReturn(tax);
        TaxDto taxDto = new TaxDto();
        BeanUtils.copyProperties(tax, taxDto);
        TaxDto result = taxService.create(taxDto);

        assertNotNull(result);
        assertEquals(tax.getBruteSalary(), result.getBruteSalary());
        assertEquals(tax.getNetSalary(), result.getNetSalary());
        assertEquals(tax.getIrrf(), result.getIrrf());

        verify(dbRepository, times(1)).save(any(Tax.class));
    }

    @Test
    void getById() {
        Long id = 1L;
        when(dbRepository.findById(id)).thenReturn(Optional.of(tax));

        Tax result = taxService.getById(id);

        assertNotNull(result);
        assertEquals(tax.getBruteSalary(), result.getBruteSalary());
        assertEquals(tax.getNetSalary(), result.getNetSalary());
        assertEquals(tax.getIrrf(), result.getIrrf());

        verify(dbRepository, times(1)).findById(id);
    }

    @Test
    void list() {
        List<Tax> taxes = Arrays.asList(tax, tax);

        when(dbRepository.findAll()).thenReturn(taxes);

        List<Tax> result = taxService.list();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(tax.getBruteSalary(), result.get(0).getBruteSalary());
        assertEquals(tax.getNetSalary(), result.get(0).getNetSalary());
        assertEquals(tax.getIrrf(), result.get(0).getIrrf());

        verify(dbRepository, times(1)).findAll();
    }

    @Test
    void delete() {
        Long id = 1L;
        taxService.delete(id);
        verify(dbRepository, times(1)).deleteById(id);
    }
}