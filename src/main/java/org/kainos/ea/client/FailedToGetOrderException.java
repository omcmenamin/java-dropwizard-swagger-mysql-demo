package org.kainos.ea.client;

public class FailedToGetOrderException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to get orders from database";
    }


    }

