package com.infnet.taxService.Controller;

import com.infnet.taxService.Dto.SalaryDto;
import com.infnet.taxService.Dto.TaxDto;
import com.infnet.taxService.Service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController {
    @Autowired
    TaxService taxService;

    @PostMapping
    public ResponseEntity<Object> saveTax(@RequestBody SalaryDto salaryDto){
        try {
            System.out.println(salaryDto.getSalary());
            TaxDto taxDto = taxService.saveTax(salaryDto);
            return ResponseEntity.status(HttpStatus.OK).body(taxDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
