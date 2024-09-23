package com.infnet.taxService.Service;

import com.infnet.taxService.Client.DatabaseClient;
import com.infnet.taxService.Client.IRRFClient;
import com.infnet.taxService.Dto.IRRFDto;
import com.infnet.taxService.Dto.SalaryDto;
import com.infnet.taxService.Dto.TaxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    @Autowired
    IRRFClient irrfClient;
    @Autowired
    DatabaseClient databaseClient;

    public TaxDto saveTax(SalaryDto salaryDto){
        IRRFDto irrfDto = irrfClient.calculate(salaryDto);
        TaxDto taxDto = new TaxDto();
        taxDto.setIrrf(irrfDto.getIrrf());
        taxDto.setNetSalary(salaryDto.getSalary() - irrfDto.getIrrf());
        taxDto.setBruteSalary(salaryDto.getSalary());
        databaseClient.save(taxDto);
        return taxDto;
    }
}
