package com.infnet.taxService.Service;

import com.infnet.taxService.Client.DatabaseClient;
import com.infnet.taxService.Client.IRRFClient;
import com.infnet.taxService.Dto.IRRFDto;
import com.infnet.taxService.Dto.SalaryDto;
import com.infnet.taxService.Dto.TaxDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaxServiceTest {
    @Mock
    private IRRFClient irrfClient;

    @Mock
    private DatabaseClient databaseClient;

    @InjectMocks
    private TaxService taxService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void saveTax() {
        // Dados de entrada
        SalaryDto salaryDto = new SalaryDto();
        salaryDto.setSalary(5000.0);  // Definindo um salário de exemplo

        IRRFDto irrfDto = new IRRFDto();
        irrfDto.setIrrf(479.00);
        when(irrfClient.calculate(salaryDto)).thenReturn(irrfDto);

        TaxDto result = taxService.saveTax(salaryDto);

        verify(irrfClient, times(1)).calculate(salaryDto);
        verify(databaseClient, times(1)).save(any(TaxDto.class));

        // Valida o resultado
        assertNotNull(result);
        assertEquals(479.00, result.getIrrf(), 0.01);
        assertEquals(4521, result.getNetSalary());
        assertEquals(5000.0, result.getBruteSalary());
    }
}