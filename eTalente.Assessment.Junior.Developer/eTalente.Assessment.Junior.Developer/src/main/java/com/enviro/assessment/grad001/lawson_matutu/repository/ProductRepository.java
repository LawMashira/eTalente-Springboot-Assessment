package com.enviro.assessment.grad001.lawson_matutu.repository;

import com.enviro.assessment.grad001.lawson_matutu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
}
