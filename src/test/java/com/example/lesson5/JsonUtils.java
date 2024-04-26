package com.example.lesson5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class JsonUtils {

    private static final ObjectMapper objectMapper = init();

    private static ObjectMapper init(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
    public static String toJson(Object object){
        String jsonAsString;
        try {
            jsonAsString = objectMapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            jsonAsString = "";
        }
        return jsonAsString;
    }

    public static JsonNode toJsonNode(String body){
        JsonNode node;
        try {
            node = objectMapper.readTree(body);
        } catch (JsonProcessingException e) {
            node = objectMapper.nullNode();
        }
        return node;
    }
}
