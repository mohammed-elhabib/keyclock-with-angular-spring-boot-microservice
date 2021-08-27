package com.example.keyclcokdemobackcend;

import lombok.Data;

import java.util.Map;
@Data
public class SenderResponse {
    private Map<String,String> message;


    public SenderResponse(Map<String,String> message) {
        super();
        this.message = message;
    }

    public Map<String,String> getMessage() {
        return message;
    }

    public void setMessage(Map<String,String> message) {
        this.message = message;
    }

}