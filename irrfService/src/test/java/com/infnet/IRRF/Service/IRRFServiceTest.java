package com.infnet.IRRF.Service;

import com.infnet.IRRF.Dto.IRRFDto;
import com.infnet.IRRF.Dto.SalaryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class IRRFServiceTest {
    private IRRFService irrfService;

    @BeforeEach
    void setUp() {
        irrfService = new IRRFService();
    }

    @Test
    void calculate() {
        SalaryDto salaryDto = new SalaryDto();
        salaryDto.setSalary(5000.0);
        IRRFDto irrfDto = irrfService.calculate(salaryDto);
        assertNotNull(irrfDto);
        assertEquals(479.00, irrfDto.getIrrf(), 0.01);
    }
}