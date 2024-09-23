package com.infnet.IRRF.Controller;

import com.infnet.IRRF.Dto.IRRFDto;
import com.infnet.IRRF.Dto.SalaryDto;
import com.infnet.IRRF.Service.IRRFService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("irrf")
@RestController
public class IRRFControler {
    @Autowired
    IRRFService irrfService;

    @PostMapping
    public ResponseEntity<Object> calcIRRF(@RequestBody @Valid SalaryDto salaryDto){
        try {
            IRRFDto irrfDto = irrfService.calculate(salaryDto);
            return ResponseEntity.status(HttpStatus.OK).body(irrfDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
