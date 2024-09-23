package com.infnet.taxService.Client;

import com.infnet.taxService.Dto.IRRFDto;
import com.infnet.taxService.Dto.SalaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "irrf-service", url = "http://localhost:8082/irrf/")
public interface IRRFClient {
    @PostMapping
    IRRFDto calculate(@RequestBody SalaryDto salaryDto);
}
