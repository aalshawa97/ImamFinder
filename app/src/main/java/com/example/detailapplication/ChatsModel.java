package com.example.detailapplication;

public class ChatsModel {

    private String message;
    private String sender;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getSender(){
        return sender;
    }

    public void setSender(String sender){
        this.sender = sender;
    }

    public ChatsModel(String message, String userKey) {
        this.message = message;
        this.sender = userKey;
    }
}
