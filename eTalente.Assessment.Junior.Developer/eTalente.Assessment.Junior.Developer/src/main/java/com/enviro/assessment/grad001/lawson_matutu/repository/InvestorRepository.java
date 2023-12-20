package com.enviro.assessment.grad001.lawson_matutu.repository;

import com.enviro.assessment.grad001.lawson_matutu.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository  extends JpaRepository <Investor,Long> {
}
