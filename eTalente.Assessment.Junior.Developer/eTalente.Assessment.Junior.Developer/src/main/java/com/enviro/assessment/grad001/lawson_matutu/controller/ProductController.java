package com.enviro.assessment.grad001.lawson_matutu.controller;

import com.enviro.assessment.grad001.lawson_matutu.entity.Investor;
import com.enviro.assessment.grad001.lawson_matutu.entity.Product;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.ProductNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.service.InvestorService;
import com.enviro.assessment.grad001.lawson_matutu.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController
{


    @Autowired
    private ProductService productService;
    @PostMapping("product")
    public ResponseEntity<String> createProduct(@RequestBody @Valid Product product) {
        String status =productService.addProduct(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }





    @GetMapping("product/{cid}")

    public  ResponseEntity<Product> getProductById(@PathVariable Long cid) throws ProductNotFoundEXception {
        Product product =productService.getProductById(cid);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List <Product> product=productService.getAllProducts();
        return  new ResponseEntity<>(product,HttpStatus.OK);
    }
    @DeleteMapping("product/{cid}")

    public  ResponseEntity<String> deleteProductById(@PathVariable Long cid){
        String  status= productService.deleteById(cid);
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }

}
