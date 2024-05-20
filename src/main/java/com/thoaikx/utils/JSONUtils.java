package com.thoaikx.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONUtils {


  public  static  void objectToJson(Object object){
    var mapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT)
        .registerModule(new JavaTimeModule());
    try {
      var json = mapper.writeValueAsString(object);
      System.out.println(json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }





}
