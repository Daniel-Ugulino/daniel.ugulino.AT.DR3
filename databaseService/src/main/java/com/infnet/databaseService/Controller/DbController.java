package com.infnet.databaseService.Controller;

import com.infnet.databaseService.Domain.Tax;
import com.infnet.databaseService.Dto.TaxDto;
import com.infnet.databaseService.Service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DbController {
    @Autowired
    DbService dbService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TaxDto taxDto){
        try {
            TaxDto taxEntity = dbService.create(taxDto);
            return ResponseEntity.status(HttpStatus.OK).body(taxEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        try {
            Tax tax = dbService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(tax);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @GetMapping
    public ResponseEntity<Object> list(){
        try {
            List<Tax> taxes = dbService.list();
            return ResponseEntity.status(HttpStatus.OK).body(taxes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        try {
            dbService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Tax Deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

}
