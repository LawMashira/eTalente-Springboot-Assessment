package com.enviro.assessment.grad001.lawson_matutu.service;

import com.enviro.assessment.grad001.lawson_matutu.entity.Product;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.ProductNotFoundEXception;

import java.util.List;

public interface ProductService {


    String addProduct(Product product);

    Product getProductById(Long CID) throws  ProductNotFoundEXception;

    List<Product> getAllProducts();

    String deleteById(Long CID);
}
