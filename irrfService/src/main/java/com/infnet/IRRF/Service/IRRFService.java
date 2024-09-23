package com.infnet.IRRF.Service;

import com.infnet.IRRF.Dto.IRRFDto;
import com.infnet.IRRF.Dto.SalaryDto;
import org.springframework.stereotype.Service;

@Service
public class IRRFService {

    public IRRFDto calculate(SalaryDto salaryDto){
        IRRFDto irrfDto = new IRRFDto();
        if (salaryDto.getSalary() <= 2259.20) {
            //Isenta
           irrfDto.setIrrf(0.0);
        } else if (salaryDto.getSalary() <= 2826.65) {
            //7,5%
            Double salary = (salaryDto.getSalary() * 0.075) - 158.40;
            irrfDto.setIrrf(salary);
        } else if (salaryDto.getSalary() <= 3751.05) {
            //15%
            Double salary = (salaryDto.getSalary() * 0.15) - 381.44;
            irrfDto.setIrrf(salary);
        } else if (salaryDto.getSalary() <= 4664.68) {
            //22,5%
            Double salary = (salaryDto.getSalary() * 0.225) - 662.77;
            irrfDto.setIrrf(salary);
        } else {
            //27,5%
            Double salary = (salaryDto.getSalary() * 0.275) - 896.00;
            irrfDto.setIrrf(salary);
        }
        return irrfDto;
    }
}
