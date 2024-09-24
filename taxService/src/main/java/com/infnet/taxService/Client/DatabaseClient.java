package com.infnet.taxService.Client;

import com.infnet.taxService.Dto.IRRFDto;
import com.infnet.taxService.Dto.TaxDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "database-service", url = "http://database-service:8083/db/")
public interface DatabaseClient {
    @PostMapping
    IRRFDto save(@RequestBody TaxDto taxDto);
}
