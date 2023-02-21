package com.sky.configuration;

import com.sky.model.Result;
import com.sky.model.Response;
import com.sky.model.Information;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> readableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        Result result = new Result();
        Response response = new Response();
        Information information = new Information();

        result.setCode("-50");
        result.setDescription("Solicitud incorrecta.");

        response.setResult(result);
        response.setInformation(information);

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
