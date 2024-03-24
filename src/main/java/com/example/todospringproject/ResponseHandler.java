package com.example.todospringproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
public class ResponseHandler {

    public static ResponseEntity<Object>generateResponse(String msg, HttpStatus status){

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("msg", msg);
        responseMap.put("status", status.value());

        return new ResponseEntity<Object>(responseMap,status);

    }
}
