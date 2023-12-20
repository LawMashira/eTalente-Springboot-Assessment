package com.enviro.assessment.grad001.lawson_matutu.service;

import com.enviro.assessment.grad001.lawson_matutu.entity.Product;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.ProductNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements  ProductService{


    @Autowired
    private ProductRepository productRepository;
    @Override
    public  String addProduct(Product product)
    {
        productRepository.save(product);
        return "Product successfully saved";
    }



    @Override
    public Product getProductById(Long CID) throws ProductNotFoundEXception {
        Optional<Product> findById = productRepository.findById(CID);

        if(findById.isPresent())   {
            return findById.get();
        }else{
            throw  new ProductNotFoundEXception("No product with  ID "+CID);
        }


    }

    @Override
    public List<Product> getAllProducts() {


        return productRepository.findAll();
    }

    @Override
    public String deleteById(Long CID) {
        if(productRepository.existsById(CID)){
            productRepository.deleteById(CID);
            return  " Product Deleted";
        }else {
            return  "No such record";
        }
    }

}
