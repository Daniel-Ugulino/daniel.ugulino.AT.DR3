package com.infnet.databaseService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaxDto {
    private Double bruteSalary;
    private Double irrf;
    private Double netSalary;

}
