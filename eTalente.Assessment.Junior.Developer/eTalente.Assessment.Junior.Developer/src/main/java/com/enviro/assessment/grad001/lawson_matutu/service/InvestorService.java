package com.enviro.assessment.grad001.lawson_matutu.service;

import com.enviro.assessment.grad001.lawson_matutu.entity.Investor;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;

import java.util.List;

public interface InvestorService {

    String addInvestor(Investor investor);

    Investor getInvestorById(Long CID) throws InvestorNotFoundEXception;

    List<Investor> getAllInvestors();

    String deleteById(Long CID);
}
