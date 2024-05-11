package org.scaler.lld4aprilevening.advice;


import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.dtos.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {


//    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionResponseDto> handleProductNotFoundException(){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setStatus(HttpStatus.NOT_FOUND);
        exceptionResponseDto.setMessage("Product not found...");

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);


    }
}
