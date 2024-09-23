package com.infnet.databaseService.Service;

import com.infnet.databaseService.Domain.Tax;
import com.infnet.databaseService.Dto.TaxDto;
import com.infnet.databaseService.Repository.DbRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DbService {
    @Autowired
    DbRepository dbRepository;

    public TaxDto create(TaxDto taxDto){
        Tax tax = new Tax();
        tax.setBruteSalary(taxDto.getBruteSalary());
        tax.setIrrf(taxDto.getIrrf());
        tax.setNetSalary(taxDto.getNetSalary());
        dbRepository.save(tax);
        return taxDto;
    }

    public Tax getById(@PathVariable("id") Long id){
        return dbRepository.findById(id).get();
    }

    public List<Tax> list(){
        return dbRepository.findAll();
    }

    public void delete(@PathVariable("id") Long id){
        dbRepository.deleteById(id);
    }
}
