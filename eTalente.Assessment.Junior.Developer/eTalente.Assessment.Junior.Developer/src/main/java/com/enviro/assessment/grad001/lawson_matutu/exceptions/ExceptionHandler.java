package com.enviro.assessment.grad001.lawson_matutu.exceptions;

import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.InvestorNotFoundEXception;
import com.enviro.assessment.grad001.lawson_matutu.exceptions.entityexceptions.ProductNotFoundEXception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidData (MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return  errorMap;

    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    @org.springframework.web.bind.annotation.ExceptionHandler(InvestorNotFoundEXception.class)
    public  Map<String ,String  > handleNotFoundException(InvestorNotFoundEXception ex){
        Map<String,String> errorMap = new HashMap();
        errorMap.put("errorMessage",ex.getMessage());
        return  errorMap;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundEXception.class)
    public  Map<String ,String  > handleNotFoundException(ProductNotFoundEXception ex){
        Map<String,String> errorMap = new HashMap();
        errorMap.put("errorMessage",ex.getMessage());
        return  errorMap;
    }
}
