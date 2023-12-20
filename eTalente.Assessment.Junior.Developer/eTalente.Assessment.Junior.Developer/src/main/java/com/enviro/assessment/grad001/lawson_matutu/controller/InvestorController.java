package com.enviro.assessment.grad001.lawson_matutu.controller;

import com.enviro.assessment.grad001.lawson_matutu.entity.Investor;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.service.InvestorService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")

public class InvestorController
{
    @Autowired
private InvestorService investorService;
    @PostMapping("investor")
    public ResponseEntity<String> createInvestor(@RequestBody @Valid Investor investor) {

        String status = investorService.addInvestor(investor);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }



    @GetMapping("investor/{cid}")

    public  ResponseEntity<Investor> getInvestorById(@PathVariable @Valid Long cid) throws InvestorNotFoundEXception {
        Investor investor =investorService.getInvestorById(cid);
        return  new ResponseEntity<>(investor, HttpStatus.OK);
    }


    @GetMapping("investors")
    public ResponseEntity<List<Investor>> getAllInvestors(){
        List <Investor> courses =investorService.getAllInvestors();
        return  new ResponseEntity<>(courses,HttpStatus.OK);
    }
    @DeleteMapping("investor/{cid}")

    public  ResponseEntity<String> deleteInvestorById(@PathVariable Long cid){
        String  status= investorService.deleteById(cid);
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }

}
