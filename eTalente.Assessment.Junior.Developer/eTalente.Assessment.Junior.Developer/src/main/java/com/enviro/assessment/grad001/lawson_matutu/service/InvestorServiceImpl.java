package com.enviro.assessment.grad001.lawson_matutu.service;

import com.enviro.assessment.grad001.lawson_matutu.entity.Investor;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvestorServiceImpl  implements  InvestorService{

    @Autowired
    private InvestorRepository investorRepository;
    @Override
    public  String addInvestor(Investor investor)
    {
        investorRepository.save(investor);
        return "Investor successfully saved";
    }



    @Override
    public Investor getInvestorById(Long CID) throws InvestorNotFoundEXception {
        Optional<Investor> findById = investorRepository.findById(CID);

        if(findById.isPresent())   {
            return findById.get();
        }else{
            throw  new InvestorNotFoundEXception("No investor with  ID "+CID);
        }


    }

    @Override
    public List<Investor> getAllInvestors() {


        return investorRepository.findAll();
    }

    @Override
    public String deleteById(Long CID) {
        if(investorRepository.existsById(CID)){
            investorRepository.deleteById(CID);
            return  " Investor Deleted";
        }else {
            return  "No such record";
        }
    }

}
